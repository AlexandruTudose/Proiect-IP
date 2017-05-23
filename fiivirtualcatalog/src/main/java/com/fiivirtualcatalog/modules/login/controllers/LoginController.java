package com.fiivirtualcatalog.modules.login.controllers;


import com.fiivirtualcatalog.modules.login.email.SmtpMailSender;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.login.password.PasswordEncrypt;
import com.fiivirtualcatalog.modules.login.services.ConfirmEmailService;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private PasswordEncrypt passwordEncrypt;


    // @CrossOrigin(origins = "http://localhost:9669")
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
                return new ResponseEntity<String>("Check email",HttpStatus.OK);
            } catch (MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<String>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    // @CrossOrigin(origins = "http://localhost:9669")
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(String email, String password){
        User userExists = userService.findByEmail(email);
        passwordEncrypt.setPassword(password);
        passwordEncrypt.setPassword(passwordEncrypt.encryptPassword());
        if (userExists == null) {
            return new ResponseEntity<String>("No user found",HttpStatus.NO_CONTENT);
        }
        else
        if(!passwordEncrypt.compare(userExists.getPassword())){
            return new ResponseEntity<String> ("Wrong password",HttpStatus.UNAUTHORIZED);
        }
        else
        if(!userExists.getActive())
            return new ResponseEntity<String>("Account not validated",HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<String> ("Logged in",HttpStatus.OK);
    }

}
