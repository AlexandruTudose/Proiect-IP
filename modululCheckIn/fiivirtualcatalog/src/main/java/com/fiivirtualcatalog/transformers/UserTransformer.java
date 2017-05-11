package com.fiivirtualcatalog.transformers;

import org.springframework.stereotype.Component;

import com.fiivirtualcatalog.modules.user.dtos.GetUserDTO;
import com.fiivirtualcatalog.modules.user.dtos.PostUserDTO;
import com.fiivirtualcatalog.modules.user.models.User;

@Component
public class UserTransformer{

	public User toModel(PostUserDTO object) {
		User user = new User ();
		user.setName(object.getName());
		user.setRole(object.getRole());
	return user;
	}

	public GetUserDTO toDTO(User object) {
		return (new GetUserDTO(object.getName(), object.getRole(), object.getId()));
	}

}
