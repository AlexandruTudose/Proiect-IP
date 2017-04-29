package com.fiivirtualcatalog.test.services;

import com.fiivirtualcatalog.test.models.TestModel;
import com.fiivirtualcatalog.test.repositories.TestModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandru on 4/27/2017.
 */

@Service
public class TestModelServiceImpl implements TestModelService {
    @Autowired
    private TestModelRepository repository;

    @Override
    public TestModel save(TestModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<TestModel> getAll() {
        return this.repository.findAll();
    }

    @Override
    public TestModel getById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }
}
