package com.fiivirtualcatalog.modules.user.services;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.services.CrudService;

import java.util.List;

public interface UserService extends CrudService<User> {
    public void existsUser (Long id) throws IllegalArgumentException;
    public User findByEmail(String email);
    public void delete(String email);
    public List<User> getAll();
    public User save(User user);
    public User update(User user);
}
