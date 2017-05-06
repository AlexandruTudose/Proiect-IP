package com.fiivirtualcatalog.modules.DTOs;

public class UserDTO {
	private String name;
	private String role;

	public UserDTO() {
	}

	public UserDTO(String name, String role) {
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
