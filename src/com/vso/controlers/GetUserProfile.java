package com.vso.controlers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.utilities.ConnectorDB;
import com.vso.interfaces.TableUsersNames;
import com.vso.interfaces.UserProfileTagsNames;
import com.vso.models.User;

/**
 * Servlet implementation class GetUserProfile
 */
@WebServlet("/GetUserProfile")
public class GetUserProfile extends HttpServlet implements TableUsersNames, UserProfileTagsNames {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserProfile() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = new User(username);
		request.setAttribute(usernameTag, user.getUsername());
		request.setAttribute(firstName, user.getFirstName());
		request.setAttribute(lastName, user.getLastName());
		request.setAttribute(email, user.getEmail());
		request.setAttribute(registrationDate, user.getRegistrationDate());
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_profile");
		dispatcher.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
