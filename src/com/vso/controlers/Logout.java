package com.vso.controlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vso.interfaces.Cookies;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet implements Cookies {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logout() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		response.setContentType("text/html");
		response.addCookie(deleteCookie(cookieUsername));
		response.addCookie(deleteCookie(cookiePassword));
		response.addCookie(deleteCookie(cookieTimeout));

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("name");
		}
		response.sendRedirect("/Recipes/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public Cookie createCookie(String CookieName, String CookieData) {
		return null;
	}

	@Override
	public Cookie deleteCookie(String CookieName) {
		Cookie cookie = new Cookie(CookieName, null);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(0);

		return cookie;
	}

}
