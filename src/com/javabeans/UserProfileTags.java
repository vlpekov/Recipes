package com.javabeans;

import java.io.Serializable;

import com.vso.interfaces.UserProfileTagsNames;

public class UserProfileTags implements Serializable, UserProfileTagsNames {
	private static final long serialVersionUID = 1L;
	
	public String getUsername() {
		return usernameTag;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public String getRecipes() {
		return recipes;
	}

}
