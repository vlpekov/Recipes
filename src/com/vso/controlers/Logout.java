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
		// TODO Auto-generated constructor stub
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

//		PrintWriter out = response.getWriter();
		// String title = "Delete Cookies Example";
		// String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
		// "transitional//en\">\n";
		// out.println(
		// docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
		// + "<body bgcolor=\"#f0f0f0\">\n");
		// out.println(
		// " <H1>JSP Reading cookies to client before: </H1> <table border=”1”>
		// <tr> <td>Cookie Name </td> <td>Cookie Value </td> <td>Cookie Max Age
		// </td> </tr>");
		// Cookie[] cookiesReadBefore = request.getCookies();
		// // check null because there are chances that there are no cookies
		// if (cookiesReadBefore != null) {
		// for (int i = 0; i < cookiesReadBefore.length; i++) {
		// Cookie cookie1 = cookiesReadBefore[i];
		// out.println(" <tr> ");
		// out.println("<td>" + cookie1.getName() + "</td>");
		// out.println("<td>" + cookie1.getValue() + "</td>");
		// out.println("<td>" + cookie1.getMaxAge() + "</td>");
		// out.println(" </tr> ");
		// }
		// }
		// out.println("</table>");
		response.addCookie(deleteCookie(cookieUsername));
		response.addCookie(deleteCookie(cookiePassword));
		response.addCookie(deleteCookie(cookieTimeout));

		// out.println(
		// " <H1>JSP Reading cookies to client after</H1> <table border=”1”>
		// <tr> <td>Cookie Name </td> <td>Cookie Value </td> <td>Cookie Max Age
		// </td> </tr>");
		// Cookie[] cookiesRead = request.getCookies();
		// // check null because there are chances that there are no cookies
		// if (cookiesRead != null) {
		// for (int i = 0; i < cookiesRead.length; i++) {
		// Cookie cookie1 = cookiesRead[i];
		// out.println(" <tr> ");
		// out.println("<td>" + cookie1.getName() + "</td>");
		// out.println("<td>" + cookie1.getValue() + "</td>");
		// out.println("<td>" + cookie1.getMaxAge() + "</td>");
		// out.println(" </tr> ");
		// }
		// }
		// out.println("</table>");
		// out.println("<a href=\"cookies.jsp\" class=\"brown_button\">Провери
		// кукитата</a>");

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("name");
		}
		// out.println("</body>");
		// out.println("</html>");
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
