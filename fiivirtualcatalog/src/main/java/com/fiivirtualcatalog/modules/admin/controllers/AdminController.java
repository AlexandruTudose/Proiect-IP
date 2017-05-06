package com.fiivirtualcatalog.modules.admin.controllers;

import com.fiivirtualcatalog.modules.DTOs.AdminDto;
import com.fiivirtualcatalog.modules.admin.models.Admin;
import com.fiivirtualcatalog.modules.admin.services.AdminService;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.transformers.AdminTransformer;
import com.fiivirtualcatalog.modules.transformers.Transformer;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/v1/admins")

public class AdminController {

    @Autowired
    UserService userService;

    private Transformer<Admin, AdminDto> transformer = new AdminTransformer();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> get() {
        List<User> users = this.userService.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }

        List<User> admins = new ArrayList<>();

        for( User user : users) {
            if( user.getRole().equals("admin")) {
                admins.add(user);
            }
        }
        if (admins.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(admins, HttpStatus.OK);
}

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId) {
        User user = this.userService.getById(userId);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        if(user.getRole().equals("admin")) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createAdmin(@RequestBody AdminDto admin){
        User savedUser = this.userService.save((User)transformer.toModel(admin));
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
}
