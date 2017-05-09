package com.fiivirtualcatalog.login.controllers;

import com.fiivirtualcatalog.login.email.SmtpMailSender;
import com.fiivirtualcatalog.login.models.ConfirmEmail;
import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.services.ConfirmEmailServiceImpl;
import com.fiivirtualcatalog.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class RegisterController {


    @Autowired
    private UserService userService;
    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    private ConfirmEmailServiceImpl confirmEmailService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user) {
        User userExists = userService.findByEmail(user.getEmail());
        if (userExists != null) {
            return new ResponseEntity<User>(HttpStatus.valueOf("User already exists"));
        } else {

            try {
                user.setActive(false);
                System.out.println(user.getPassword());
                userService.save(user);
                ConfirmEmail confirmEmail=new ConfirmEmail();
                confirmEmail.setEmail(user.getEmail());
                confirmEmail.setCode(confirmEmailService.generateCode());
                smtpMailSender.send(user.getEmail(),"Email confirmation!",confirmEmail.getCode());
                confirmEmailService.delete(user.getEmail());
                confirmEmailService.save(confirmEmail);
                return new ResponseEntity<User>(HttpStatus.OK);

            } catch (MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @RequestMapping(value="/register/validate",method = RequestMethod.GET)
    public ResponseEntity<String> checkEmailCode(String email,String code) {
        ConfirmEmail confirmEmail=new ConfirmEmail();
        confirmEmail=confirmEmailService.findEmail(email);
        if(confirmEmail!=null && confirmEmail.getCode().compareTo(code)==0) {
                User user=userService.findByEmail(email);
                user.setActive(true);
                userService.save(user);
                return new ResponseEntity<String>(HttpStatus.OK);
            }
            else
                return  new ResponseEntity<String>(email,HttpStatus.valueOf("Wrong code"));
    }


}
