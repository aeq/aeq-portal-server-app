package com.aeq.portal.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author abhisheknair
 *
 */

public class UserModel {

	@NotNull(message = "Email should not be empty")
	@Email(message = "Enter a valid email")
	private String email;

	@NotNull(message = "Password should not be empty")
	@Size(min = 5, message = "Password should be atleast 5 characters")
	private String password;

	@NotNull(message = "Role should not be empty")
	private String role;

	//private UserProfileModel userProfileModel;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
