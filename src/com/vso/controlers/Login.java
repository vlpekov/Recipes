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

import com.database.utilities.*;
import com.vso.interfaces.Cookies;
import com.vso.models.Password;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet implements Cookies {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hashPassword = null;
		try {
			hashPassword = Password.getSaltedHash(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute("name", username);
		}

		if (LoginCheck.validatePassword(username, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			response.addCookie(createCookie(cookieUsername, username));
			response.addCookie(createCookie(cookiePassword, hashPassword));
			dispatcher.forward(request, response);
		} else {
			out.print("<p style=\"color:red\">Грешно потребителско име или парола.</p>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
		}
		out.close();
	}

	@Override
	public Cookie createCookie(String CookieName, String CookieData) {
		Cookie newCookie = new Cookie(CookieName, CookieData);
		newCookie.setMaxAge(sessionExpiryTime);
		newCookie.setPath("/");
		return newCookie;
	}

	@Override
	public Cookie deleteCookie(String CookieName) {
		return null;
	}

}
