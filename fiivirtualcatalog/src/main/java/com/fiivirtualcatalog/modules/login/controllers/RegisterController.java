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
        User userExists = userService.findByEmail(user.getEmail());
        if (userExists != null) {
            System.out.println(userExists.getEmail()+" "+userExists.getLastName()+" "+userExists.getFirstName());
            return new ResponseEntity<String>("User already exists", HttpStatus.CONFLICT);
        } else {

            try {
                user.setActive(false);
                user.setValidated(false);
                userService.save(user);
                ConfirmEmail confirmEmail = new ConfirmEmail();
                confirmEmail.setEmail(user.getEmail());
                confirmEmail.setCode(confirmEmailService.generateCode());
                String link="http://localhost:3100/register/validate/?email="+user.getEmail()+
                        "&code="+confirmEmail.getCode();
                String message="  &#160&#160  You are receiving this email because someone attempted to register on our website.<br>" +
                                "If that's you, please click on the link below to confirm your email address!<br>"+
                                "<a href=\""+link+"\">"+link+"</a>";
                smtpMailSender.send(user.getEmail(), "Email confirmation!",message);
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
    public ResponseEntity<String> checkEmailCode(@RequestParam(value = "email") String email,@RequestParam(value = "code") String code) {
        ConfirmEmail confirmEmail = new ConfirmEmail();
        confirmEmail = confirmEmailService.findEmail(email);
        if (confirmEmail != null && confirmEmail.getCode().compareTo(code) == 0) {
            User user = userService.findByEmail(email);
            user.setValidated(true);
            userService.update(user);
            confirmEmailService.delete(user.getEmail());
            System.out.println("Validation completed");
            return new ResponseEntity<String>("Validation completed", HttpStatus.OK);
        } else {
            System.out.println("Wrong code");
            return new ResponseEntity<String>("Wrong code", HttpStatus.NOT_FOUND);
        }
    }
}
