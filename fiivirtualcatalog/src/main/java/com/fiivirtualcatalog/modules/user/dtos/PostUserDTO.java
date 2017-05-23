package com.fiivirtualcatalog.modules.user.dtos;

import com.fiivirtualcatalog.modules.user.models.User;

public class PostUserDTO {
	private String role;
	private String email;
	private String firstName;
	private String lastName;
	private boolean active;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PostUserDTO() {
	}

	public PostUserDTO(String firstName, String role){
        this.firstName = firstName;
        this.role = role;
    }
	public PostUserDTO(String role,
            String email,
            String firstName,
            String lastName,
            boolean active,
            String password) {
		this.firstName = firstName;
		this.role = role;
		this.email = email;
		this.lastName = lastName;
		this.active = active;
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
