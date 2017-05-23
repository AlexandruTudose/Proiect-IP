package com.fiivirtualcatalog.modules.login.controllers;


import com.fiivirtualcatalog.modules.login.email.SmtpMailSender;
import com.fiivirtualcatalog.modules.login.models.ConfirmEmail;
import com.fiivirtualcatalog.modules.login.services.ConfirmEmailServiceImpl;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
public class RegisterController {


    private UserService service;

    public RegisterController(UserService service) {
        this.service = service;
    }

    @Autowired
    private UserService userService;
    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    private ConfirmEmailServiceImpl confirmEmailService;

    @CrossOrigin(origins = "http://localhost:3100")
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
        System.out.println(user.getActive());
        System.out.println(user.getId());
        User userExists = userService.findByEmail(user.getEmail());
        if (userExists != null) {
            return new ResponseEntity<String>("User already exists", HttpStatus.CONFLICT);
        } else {

            try {
                user.setActive(false);
                userService.save(user);
                ConfirmEmail confirmEmail = new ConfirmEmail();
                confirmEmail.setEmail(user.getEmail());
                confirmEmail.setCode(confirmEmailService.generateCode());
                smtpMailSender.send(user.getEmail(), "Email confirmation!", confirmEmail.getCode());
                confirmEmailService.delete(user.getEmail());
                confirmEmailService.save(confirmEmail);
                System.out.println("Validate email");
                return new ResponseEntity<String>("Validate email", HttpStatus.OK);

            } catch (MessagingException e) {
                e.printStackTrace();
                System.out.println("Internal server error");
                return new ResponseEntity<String>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @CrossOrigin(origins = "http://localhost:3100")
    @RequestMapping(value = {"/register/validate"}, method = RequestMethod.POST)
    public ResponseEntity<String> checkEmailCode(String email, String code) {
        ConfirmEmail confirmEmail = new ConfirmEmail();
        confirmEmail = confirmEmailService.findEmail(email);
        if (confirmEmail != null && confirmEmail.getCode().compareTo(code) == 0) {
            User user = userService.findByEmail(email);
            user.setActive(true);
            userService.update(user);
            System.out.println("Validation completed");
            return new ResponseEntity<String>("Validation completed", HttpStatus.OK);
        } else {
            System.out.println("Wrong code");
            return new ResponseEntity<String>("Wrong code", HttpStatus.NOT_FOUND);
        }
    }
}
