package com.javabeans;

import java.io.Serializable;

import com.vso.interfaces.FormNamesRegistration;

public class FormRegistration implements Serializable, FormNamesRegistration {
	private static final long serialVersionUID = 1L;

	public String getUsernameInputName() {
		return usernameInputName;
	}

	public String getFirstNameInputName() {
		return firstNameInputName;
	}

	public String getLastNameInputName() {
		return lastNameInputName;
	}

	public String getEmailInputName() {
		return emailInputName;
	}

	public String getPasswordInputName() {
		return passwordInputName;
	}

	public String getPasswordConfirmInputName() {
		return passwordConfirmInputName;
	}

	public String getPictureInputName() {
		return pictureInputName;
	}

}
