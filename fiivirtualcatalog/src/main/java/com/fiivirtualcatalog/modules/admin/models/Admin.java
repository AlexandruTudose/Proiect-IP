package com.fiivirtualcatalog.modules.admin.models;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserServiceImpl;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin extends User implements Serializable{
    private static final long serialVersionUID = -5607554818203801248L;

    public Admin(){

    }
    public Admin(User user){
        this.setId(user.getId());
        this.setName(user.getName());
        this.setRole("admin");
    }
}
