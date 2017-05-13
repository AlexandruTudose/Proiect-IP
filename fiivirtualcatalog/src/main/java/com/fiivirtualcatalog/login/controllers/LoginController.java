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

    @CrossOrigin(origins = "http://localhost:9669")
    @RequestMapping(value={"/login/password"},method = RequestMethod.POST)
    public ResponseEntity<String> sendPassword(@RequestBody String email) {
        User userExists = userService.findByEmail(email);
        userExists.setPassword(confirmEmailService.generateCode());
        if (userExists == null) {
            return new ResponseEntity<String>("Email not found",HttpStatus.NOT_FOUND);
        }
        else {
            try {
                smtpMailSender.send(email,"Password recover!","The password for your account is: "+userExists.getPassword());
                userService.save(userExists);
                return new ResponseEntity<String>("Check email",HttpStatus.OK);
            } catch (MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<String>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @CrossOrigin(origins = "http://localhost:9669")
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(String email, String password){
        User userExists = userService.findByEmail(email);
        if (userExists == null) {
            return new ResponseEntity<String>("No user found",HttpStatus.NO_CONTENT);
        }
        else
            if(password.compareTo(userExists.getPassword())!=0){
                return new ResponseEntity<String> ("Wrong password",HttpStatus.NOT_FOUND);
        }
        else
            if(userExists.getActive()==false)
                return new ResponseEntity<String>("Account not validated",HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<String> ("Logged in",HttpStatus.OK);
    }

}
