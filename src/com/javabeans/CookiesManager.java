package com.javabeans;

import javax.servlet.http.Cookie;

import com.vso.interfaces.Cookies;
import com.vso.models.*;
import com.database.utilities.UserManager;

public class CookiesManager implements Cookies {
	
	private String currentUsername;

	public String getNameCookieUsername() {
		return cookieUsername;
	}

	public String getNameCookiePassword() {
		return cookiePassword;
	}

	public String getNameCookieTimeout() {
		return cookieTimeout;
	}

	public String getCurrentUsername() {
		return currentUsername;
	}
	
	@Override
	public Cookie createCookie(String CookieName, String CookieData) {
		return null;
	}

	@Override
	public Cookie deleteCookie(String CookieName) {
		return null;
	}

	public boolean isUserCorrect(Cookie[] cookies) {
		String username = null;
		String password = null;
		boolean isUserCorrect = false;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals(cookieUsername)) {
					username = cookie.getValue();
					this.currentUsername = username;
				}
				if (cookie.getName().equals(cookiePassword)) {
					password = cookie.getValue();
				}
			}
		}
		String dbPassword = new UserManager().getUserPasswordFromDB(username);
		try {
			isUserCorrect = Password.checkCookiePassword(password, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUserCorrect;
	}

}
