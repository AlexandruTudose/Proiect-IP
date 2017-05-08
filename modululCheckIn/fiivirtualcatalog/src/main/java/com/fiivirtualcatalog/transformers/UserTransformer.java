package com.fiivirtualcatalog.transformers;

import org.springframework.stereotype.Component;

import com.fiivirtualcatalog.modules.user.dtos.UserDTO;
import com.fiivirtualcatalog.modules.user.models.User;

@Component
public class UserTransformer{

	public User toModel(UserDTO object) {
		User user = new User ();
		user.setName(object.getName());
		user.setRole(object.getRole());
	return user;
	}

	public UserDTO toDTO(User object) {
		return (new UserDTO(object.getName(), object.getRole()));
	}

}
