package com.fiivirtualcatalog.modules.admin.services;

import com.fiivirtualcatalog.modules.admin.repositories.AdminRepository;
import com.fiivirtualcatalog.modules.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
