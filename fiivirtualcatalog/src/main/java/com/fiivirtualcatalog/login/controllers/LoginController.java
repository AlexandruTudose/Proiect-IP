package com.fiivirtualcatalog.login.controllers;

import com.fiivirtualcatalog.login.email.SmtpMailSender;
import com.fiivirtualcatalog.login.models.ConfirmEmail;
import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.moss.Moss;
import com.fiivirtualcatalog.login.services.ConfirmEmailService;
import com.fiivirtualcatalog.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(value="/login/password",method = RequestMethod.POST)
    public ResponseEntity<User> sendPassword(@RequestBody String email) {
        User userExists = userService.findByEmail(email);
        userExists.setPassword(confirmEmailService.generateCode());
        if (userExists == null) {
            return new ResponseEntity<User>(HttpStatus.valueOf("This email is not registered"));
        }
        else {
            try {
                smtpMailSender.send(email,"Password recover!","The password for your account is: "+userExists.getPassword());
                userService.save(userExists);
                return new ResponseEntity<User>(HttpStatus.valueOf("Please check your email"));
            } catch (MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<User>login(String email, String password){
        User userExists = userService.findByEmail(email);
        if (userExists == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else
            if(password.compareTo(userExists.getPassword())!=0){
                return new ResponseEntity<User>(HttpStatus.valueOf("Wrong password"));
        }
        else
            if(userExists.getActive()==false)
                return new ResponseEntity<User>(HttpStatus.valueOf("Account not validate"));
        else
            return new ResponseEntity<User>(HttpStatus.OK);
    }

}
