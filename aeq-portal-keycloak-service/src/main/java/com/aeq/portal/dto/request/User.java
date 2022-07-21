/**
 * 
 */
package com.aeq.portal.dto.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author abhisheknair
 *
 */
public class User {

	@NotNull(message = "Username should not be empty")
	private String username;

	@NotNull(message = "Last Name should not be empty")
	private String lastName;

	@NotNull(message = "First Name should not be empty")
	private String firstName;

	@NotNull(message = "Email should not be empty")
	@Email(message = "Enter a valid email")
	private String email;

	final private boolean enabled = true;
	final private boolean emailVerified = false;

	@JsonProperty("credentials")
	private List<Credentials> credentials;

	private List<String> realmRoles;

	public List<String> getRealmRoles() {
		return realmRoles;
	}

	public void setRealmRoles(List<String> realmRoles) {
		this.realmRoles = realmRoles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public List<Credentials> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<Credentials> credentials) {
		this.credentials = credentials;
	}

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", enabled=" + enabled + ", emailVerified=" + emailVerified + ", credentials="
				+ credentials.toString() + ", realmRoles=" + realmRoles + "]";
	}

}
