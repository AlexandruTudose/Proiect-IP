package com.fiivirtualcatalog.modules.login.controllers;


import com.fiivirtualcatalog.modules.login.email.SmtpMailSender;
import com.fiivirtualcatalog.modules.login.services.ConfirmEmailService;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ConfirmEmailService confirmEmailService;
    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


     @CrossOrigin(origins = "http://localhost:3100")
    @RequestMapping(value={"/login/password"},method = RequestMethod.POST)
    public ResponseEntity<String> sendPassword(@RequestParam String email) {
        User userExists = userService.findByEmail(email);
        userExists.setPassword(confirmEmailService.generateCode());
        if (userExists == null) {
            return new ResponseEntity<String>("Email not found", HttpStatus.NOT_FOUND);
        }
        else {
            try {
                smtpMailSender.send(email,"Password recover!","The password for your account is: "+userExists.getPassword());
                userService.save(userExists);
                return new ResponseEntity<String>("Check email", HttpStatus.OK);
            } catch (MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<String>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @CrossOrigin(origins = "http://localhost:3100")
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(String email, String password){
        System.out.println(email);
        System.out.println(password);
        User userExists = userService.findByEmail(email);
        if (userExists == null) {
            System.out.println("No user found");
            return new ResponseEntity<String>("No user found", HttpStatus.NO_CONTENT);
        }
        else
        if(!bCryptPasswordEncoder.matches(password,userExists.getPassword())){
            System.out.println("Wrong password");
            return new ResponseEntity<String>("Wrong email/password", HttpStatus.NOT_FOUND);
        }
        else
        if(!userExists.getActive()) {
            System.out.println("Account not validated");
            return new ResponseEntity<String>("Account not validated", HttpStatus.FORBIDDEN);
        }
        else {
            System.out.println("Logged in");
            return new ResponseEntity<String>(Integer.toString((int) userExists.getId()), HttpStatus.OK);
        }
    }

}
