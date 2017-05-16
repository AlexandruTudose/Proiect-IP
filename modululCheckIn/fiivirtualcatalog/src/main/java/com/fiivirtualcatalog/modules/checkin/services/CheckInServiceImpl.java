package com.fiivirtualcatalog.modules.checkin.services;

import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.checkin.repositories.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private CheckInRepository repository;

    @Override
    public CheckIn save(CheckIn entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<CheckIn> getAll() {
        return this.repository.findAll();
    }

    @Override
    public CheckIn getById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }

	@Override
	public void deleteAll() {
		this.repository.deleteAll();
	}
}