package com.fiivirtualcatalog.modules.admin.models;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User{
    @Autowired
    UserService userService;
    List<User> getAllAdmins(){
        List<User> users = new ArrayList<>();
        for (User user : this.userService.getAll())
            if (user.getRole().toLowerCase() == "admin")
                users.add(user);
        return users;
    }

    Admin(User user){
        this.setId(user.getId());
        this.setName(user.getName());
        this.setRole("admin");
    }
}
