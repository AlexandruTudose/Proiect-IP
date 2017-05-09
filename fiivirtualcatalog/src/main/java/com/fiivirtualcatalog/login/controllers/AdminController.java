package com.fiivirtualcatalog.login.controllers;

import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/admin/users", method = RequestMethod.POST)
    public ResponseEntity<User> delete(@RequestBody String email) {
        User userExists = userService.findByEmail(email);
        if (userExists == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } else {
            userService.delete(email);
            return new ResponseEntity<User>(HttpStatus.OK);
        }
    }

    @RequestMapping(value="/admin/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>>users(){
        List<User> students=this.userService.getAll();
        if(students.isEmpty())
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<List<User>>(students,HttpStatus.OK);
    }
}
