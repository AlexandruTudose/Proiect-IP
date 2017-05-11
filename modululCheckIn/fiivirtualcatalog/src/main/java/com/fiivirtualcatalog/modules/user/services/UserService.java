package com.fiivirtualcatalog.modules.user.services;

import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.services.CrudService;

public interface UserService extends CrudService<User> {
	 public void existsUser (Long id) throws IllegalArgumentException;
}