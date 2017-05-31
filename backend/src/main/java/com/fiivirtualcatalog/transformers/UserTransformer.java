package com.fiivirtualcatalog.transformers;

import org.springframework.stereotype.Component;

import com.fiivirtualcatalog.modules.user.dtos.GetUserDTO;
import com.fiivirtualcatalog.modules.user.dtos.PostUserDTO;
import com.fiivirtualcatalog.modules.user.models.User;

@Component
public class UserTransformer{

	public User toModel(PostUserDTO object) {
		User user = new User ();
		user.setFirstName(object.getFirstName());
		user.setLastName(object.getLastName());
		user.setRole(object.getRole());
		user.setPassword(object.getPassword());
		user.setActive(object.isActive());

		user.setEmail(object.getEmail());
	    return user;
	}

	public GetUserDTO toDTO(User object) {
		return (new GetUserDTO(object.getFirstName(),
				object.getLastName(),
				object.getRole(),
				object.isActive(),
				object.getId(),
				object.getEmail(),
				object.isValidated()));
	}

}
