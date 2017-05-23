package com.fiivirtualcatalog.modules.user.services;

import com.fiivirtualcatalog.modules.login.password.PasswordEncrypt;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncrypt passwordEncrypt;

    @Override
    public User save(User user) {
        passwordEncrypt.setPassword(user.getPassword());
        user.setPassword(passwordEncrypt.encryptPassword());
        System.out.println(user.getPassword());
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String email) {
        repository.delete(repository.findByEmail(email));
    }

    @Override
    public User getById(Long id){
        return this.repository.findOne(id);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
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

