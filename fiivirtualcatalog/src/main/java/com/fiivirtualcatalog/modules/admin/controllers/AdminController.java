package com.fiivirtualcatalog.modules.admin.controllers;

import com.fiivirtualcatalog.modules.DTOs.UserDTO;
import com.fiivirtualcatalog.modules.transformers.Transformer;
import com.fiivirtualcatalog.modules.transformers.UserTransformer;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/admins")

public class AdminController {
    @Autowired
    UserService service;

    private Transformer<User, UserDTO> transformer = new UserTransformer();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> get() {
        List<User> users = this.service.getAll();
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
        User user = this.service.getById(userId);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        if(user.getRole().equals("admin")) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createAdmin(@RequestBody UserDTO user) {
        User tempUser = transformer.toModel(user);
        tempUser.setRole("admin");
        User savedUser = this.service.save(tempUser);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    public ResponseEntity<User> updateById(@PathVariable("userId") Long updateId, @RequestBody UserDTO update) {
        User user = this.service.getById(updateId);
        if (user == null || !user.getRole().equalsIgnoreCase("admin")) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        User userUpdate=transformer.toModel(update);

        user.setRole(userUpdate.getRole());
        user.setName(userUpdate.getName());
        User userSaved = this.service.save(user);
        return new ResponseEntity<User>(userSaved, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity<List<User>> deleteById(@PathVariable("userId") Long deleteId){

        User user = this.service.getById(deleteId);
        if (user == null || !user.getRole().equalsIgnoreCase("admin")) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }

        this.service.delete(deleteId);
        List<User> del = this.service.getAll();
        return new ResponseEntity<List<User>>(del, HttpStatus.OK);
    }
}
