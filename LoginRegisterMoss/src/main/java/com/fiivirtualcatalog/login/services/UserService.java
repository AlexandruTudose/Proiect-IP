package com.fiivirtualcatalog.login.services;


import com.fiivirtualcatalog.login.models.User;

import java.util.List;

public interface UserService{

    public User findByEmail(String email);
    public void delete(String email);
    public List<User> getAll();
    public User save(User user);
    public User update(User user);
}

