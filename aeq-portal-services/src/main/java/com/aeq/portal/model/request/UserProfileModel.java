/**
 * 
 */
package com.aeq.portal.model.request;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

/**
 * @author abhisheknair
 *
 */
public class UserProfileModel {

	@NotBlank(message = "First Name should not be empty")
	private String firstName;

	private String middleName;

	@NotBlank(message = "Last Name should not be empty")
	private String lastName;

	@Digits(message = "Provide valid phone number", fraction = 0, integer = 10)
	private String phoneNumber;

	@NotBlank(message = "Date of Birth should not be empty")
	private Date dateOfBirth;

	@Column(name = "profile_image")
	private String profileImage;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

}
