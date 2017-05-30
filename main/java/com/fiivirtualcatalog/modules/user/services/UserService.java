package com.fiivirtualcatalog.modules.user.services;


import com.fiivirtualcatalog.modules.user.models.User;

import java.util.List;

public interface UserService {

    public User findByEmail(String email);
    public void delete(Long id);
    public List<User> getAll();
    public User save(User user);
    public User update(User user);
    public User findById(Long id);
}

