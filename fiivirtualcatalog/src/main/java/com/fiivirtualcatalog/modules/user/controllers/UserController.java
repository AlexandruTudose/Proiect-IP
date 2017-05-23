package com.fiivirtualcatalog.modules.user.controllers;

import com.fiivirtualcatalog.modules.user.dtos.GetUserDTO;
import com.fiivirtualcatalog.modules.user.dtos.PostUserDTO;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import com.fiivirtualcatalog.transformers.UserTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody PostUserDTO user) {
        this.service.save(transformer.toModel(user));
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
