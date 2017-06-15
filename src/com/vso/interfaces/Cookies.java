package com.vso.interfaces;

import javax.servlet.http.Cookie;

public interface Cookies {
	int days = 1;
	int hours = 0;
	int sessionExpiryTime = (days * 24 + hours) * 60 * 60;
	String cookieUsername = "username";
	String cookiePassword = "password";
	String cookieTimeout = "timeout";

	Cookie createCookie(String CookieName, String CookieData);
	
	Cookie deleteCookie(String CookieName);

}
