package com.fiivirtualcatalog.modules.user.dtos;

public class PostUserDTO {
	private String name;
	private String role;

	public PostUserDTO() {
	}

	public PostUserDTO(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
