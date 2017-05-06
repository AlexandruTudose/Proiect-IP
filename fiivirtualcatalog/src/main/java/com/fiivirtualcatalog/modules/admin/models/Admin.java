package com.fiivirtualcatalog.modules.admin.models;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import com.fiivirtualcatalog.modules.user.services.UserServiceImpl;
import org.mapstruct.InheritConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Admin extends User implements Serializable{
    private static final long serialVersionUID = -5607554818203801248L;

    public Admin(){

    }
    public Admin(User user){
        this.setId(user.getId());
        this.setName(user.getName());
        this.setRole("admin");
    }

    List<User> getAllAdmins(){
        List<User> users = new ArrayList<>();
        for (User user : new UserServiceImpl().getAll())
            if (user.getRole().toLowerCase().equals("admin"))
                users.add(user);
        return users;
    }
    List<User> getAllByName(String name){
        Pattern pattern = Pattern.compile("*" + name + "*");
        Matcher matcher;
        List<User> users = new ArrayList<>();
        for (User user : new UserServiceImpl().getAll()){
            matcher = pattern.matcher(user.getName());
            if (matcher.matches())
                users.add(user);
        }
        return users;
    }
}
