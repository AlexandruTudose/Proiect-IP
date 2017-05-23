package com.fiivirtualcatalog.modules.user.dtos;

public class GetUserDTO {
	private long id;
	private String name;
	private String role;

	public GetUserDTO() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public GetUserDTO(String name, String role, long id) {
		this.name = name;
		this.role = role;
		this.id = id;
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
