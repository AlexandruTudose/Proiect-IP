package com.fiivirtualcatalog.modules.user.controllers;

import com.fiivirtualcatalog.modules.user.dtos.GetUserDTO;
import com.fiivirtualcatalog.modules.user.dtos.PostUserDTO;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import com.fiivirtualcatalog.transformers.UserTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserTransformer transformer;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GetUserDTO>> get() {
        List<User> users = this.service.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<GetUserDTO>>(HttpStatus.NO_CONTENT);
        }
        List<GetUserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(transformer.toDTO(user));
        }
        return new ResponseEntity<List<GetUserDTO>>(usersDTO, HttpStatus.OK);
    }

    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User userExist = service.findById(id);
        if (userExist==null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else
        {
            userExist.setPassword("");
            return new ResponseEntity<User>(userExist, HttpStatus.OK);
        }
    }

    @RequestMapping(value="{id}",method = RequestMethod.POST)
    public ResponseEntity<String> activateUser(@PathVariable("id") Long id) {
        User userExist = service.findById(id);
        if (userExist==null) {
            return new ResponseEntity<String>("No user found",HttpStatus.NO_CONTENT);
        }
        else
        {
            userExist.setActive(true);
            service.update(userExist);
            return new ResponseEntity<String>("User activated", HttpStatus.OK);
        }
    }

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody PostUserDTO user) {
        this.service.save(transformer.toModel(user));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        User userExist = service.findById(id);
        if(userExist==null)
            return new ResponseEntity<String>("No user found",HttpStatus.NOT_FOUND);
        else {
            service.delete(id);
            return new ResponseEntity<String>("User deleted",HttpStatus.OK);
        }
    }
}
