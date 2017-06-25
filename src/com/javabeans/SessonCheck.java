package com.javabeans;

import java.io.Serializable;

import javax.servlet.http.Cookie;

import com.vso.interfaces.Cookies;

public class SessonCheck implements Serializable, Cookies {
	public void sessionCheck()  {
		Cookie[] cookies = request.getCookies();
		// check null because there are chances that there are no cookies
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				out.println(" <tr> ");
				out.println("<td>" + cookie.getName() + "</td>");
				out.println("<td>" + cookie.getValue() + "</td>");
				out.println("<td>" + cookie.getMaxAge() + "</td>");
				out.println(" </tr> ");
			}
		}
	}

	@Override
	public Cookie createCookie(String CookieName, String CookieData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cookie deleteCookie(String CookieName) {
		// TODO Auto-generated method stub
		return null;
	}
}
