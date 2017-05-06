package com.fiivirtualcatalog.modules.admin.models;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin extends User{
    @Autowired
    private UserService userService;

    Admin(User user){
        this.setId(user.getId());
        this.setName(user.getName());
        this.setRole("admin");
    }

    List<User> getAllAdmins(){
        List<User> users = new ArrayList<>();
        for (User user : this.userService.getAll())
            if (user.getRole().toLowerCase().equals("admin"))
                users.add(user);
        return users;
    }
    List<User> getAllByName(String name){
        Pattern pattern = Pattern.compile("*" + name + "*");
        Matcher matcher;
        List<User> users = new ArrayList<>();
        for (User user : this.userService.getAll()){
            matcher = pattern.matcher(user.getName());
            if (matcher.matches())
                users.add(user);
        }
        return users;
    }
    
}
