package com.fiivirtualcatalog.modules.admin.services;

import com.fiivirtualcatalog.modules.admin.models.Admin;
import com.fiivirtualcatalog.modules.admin.repositories.AdminRepository;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository repository;

    @Override
    public List<User> getAll() { return this.repository.findAll(); }

    @Override
    public User getById(Long id) { return this.repository.findOne(id); }

    @Override
    public User save(User entity) { return this.repository.save(entity); }

    @Override
    public void delete(Long id) { this.repository.delete(id); }

    public List<Admin> getAllAdmins(){
        List<Admin> users = new ArrayList<>();
        for (User user : getAll())
            if (user.getRole().toLowerCase().equals("admin"))
                users.add(new Admin(user));
        return users;
    }

    public List<Admin> getAllByName(String name){
        Pattern pattern = Pattern.compile("*" + name + "*");
        Matcher matcher;
        List<Admin> users = new ArrayList<>();
        for (User user : getAll()){
            matcher = pattern.matcher(user.getName());
            if (matcher.matches())
                users.add(new Admin(user));
        }
        return users;
    }
}
