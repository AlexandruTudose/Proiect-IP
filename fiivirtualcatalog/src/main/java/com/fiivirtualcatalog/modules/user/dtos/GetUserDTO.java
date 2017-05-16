package com.fiivirtualcatalog.modules.user.dtos;

import com.fiivirtualcatalog.modules.user.models.User;

public class GetUserDTO {
	private long id;
	private String role;
    private String email;
    private String firstName;
    private String lastName;
    private boolean active;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	public GetUserDTO() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public GetUserDTO(String firstName, String role, long id){
        this.firstName = firstName;
        this.role = role;
        this.id = id;
    }

	public GetUserDTO(String firstName,
                      String lastName,
                      String role,
                      boolean active,
                      long id,
                      String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.id = id;
		this.active = active;
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
