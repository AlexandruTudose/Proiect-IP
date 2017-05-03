package com.fiivirtualcatalog.login.services;


import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(String email) {
        userRepository.delete(userRepository.findByEmail(email));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
       return userRepository.save(user);
    }



}
