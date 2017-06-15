package com.vso.controlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.utilities.Conector;
import com.database.utilities.SetupDB;
import com.vso.models.Password;
import com.vso.interfaces.*;

/**
 * Servlet implementation class PasswordValidation
 */
@WebServlet("/RegistrationValidation")
@MultipartConfig(maxFileSize = 16177216)
public class RegistrationValidation extends HttpServlet implements RegistrationForm,  {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		passwordValidation(request.getParameter(passwordInputName), request.getParameter(passwordConfirmInputName),
				request, response);
		String username = request.getParameter(usernameInputName);
		String firstName = request.getParameter(firstNameInputName);
		String lastName = request.getParameter(secondNameInputName);
		String email = request.getParameter(emailInputName);
		System.out.println(username + " " + firstName + " " + lastName + " " + email);
		Date currentDate = new Date(new Date().getTime());
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		int result = 0;
		Connection connectionDB = null;
		Part filePart = request.getPart("image");
		if (filePart != null) {
			System.out.println(
					"================== До тук всичко е ок ------------------filePart------------filePart------------filePart---------");
		} else {
			System.out.println("filePart null ***************************************************** filePart");
		}

		System.out.println("================== До тук всичко е ок ---------------------------------------------------");
		try {
			InputStream fileContent = filePart.getInputStream();
			String password = new Password().getSaltedHash(passwordInputName);
			connectionDB = Conector.getInstance().getConnection();

			PreparedStatement pre = connectionDB.prepareStatement(
					"INSERT INTO `recipes_site`.`users` (`username`, `password`, `first_name`, `last_name`, `email`, `date_of_registration`, `gender`, `is_remember`, `image`, `image_name`) VALUES (?,?,?,?,?,?,?,?,?,?);");
			pre.setString(1, username);
			pre.setString(2, password);
			pre.setString(3, firstName);
			pre.setString(4, lastName);
			pre.setString(5, email);
			pre.setDate(6, sqlDate);
			pre.setString(7, "who cares");
			pre.setInt(8, 0);
			pre.setBlob(9, fileContent);
			pre.setString(10, "" + username + "_image");
			pre.executeUpdate();
			pre.close();
			// String L_url1 = response.encodeRedirectURL("myUpload.jsp");
			// response.sendRedirect(L_url1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

	private void passwordValidation(String passwordOne, String passwordTwo, HttpServletRequest request,
			HttpServletResponse response) {
		if (passwordOne != "" && passwordTwo != "") {
			if (!passwordOne.equals(passwordTwo)) {
				request.setAttribute("status", "<div class=\"error\" >Грешно въведена парола.</div>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				try {
					dispatcher.include(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void usernameValidation(String username, Connection connectionDB, HttpServletRequest request,
			HttpServletResponse response) {
		ResultSet results = null;
		Statement statement;
		String query = "SELECT * FROM " + SetupDB.getDbName() + "." + usersTableName + " where " + usernameColumn + "='"
				+ username + "'";
		try {
			connectionDB = Conector.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				dbPassword = results.getString("password");
			}
			return dbPassword;
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}

		if (!passwordOne.equals(passwordTwo)) {
			request.setAttribute("status", "<div class=\"error\" >Грешно въведена парола.</div>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			try {
				dispatcher.include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
