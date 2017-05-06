package com.fiivirtualcatalog.modules.orar.services;

import com.fiivirtualcatalog.modules.orar.models.Orar;
import com.fiivirtualcatalog.modules.orar.repositories.OrarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrarServiceImpl implements OrarService {

    @Autowired
    private OrarRepository repository;

    @Override
    public Orar save(Orar entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<Orar> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Orar getById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }
}
