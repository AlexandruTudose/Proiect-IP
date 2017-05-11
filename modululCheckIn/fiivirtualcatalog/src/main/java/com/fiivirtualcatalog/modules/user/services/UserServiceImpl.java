package com.fiivirtualcatalog.modules.user.services;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User save(User entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User getById(Long id){
        return this.repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }
    
    public void existsUser (Long id) throws IllegalArgumentException{
    	User user = getById(id);
    		if (user == null) {
    			throw new IllegalArgumentException("User not found");
    		}
    	
    }
}
