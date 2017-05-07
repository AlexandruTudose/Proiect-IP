package com.fiivirtualcatalog.modules.user.dtos;

import com.fiivirtualcatalog.transformers.Transformer;
import org.springframework.stereotype.Component;

import com.fiivirtualcatalog.modules.user.models.User;

@Component
public class UserTransformer implements Transformer<User, UserDTO> {

	@Override
	public User toModel(UserDTO object) {
		User user = new User ();
		user.setName(object.getName());
		user.setRole(object.getRole());
	return user;
	}

	@Override
	public UserDTO toDTO(User object) {
		return (new UserDTO(object.getName(), object.getRole()));
	}

}
