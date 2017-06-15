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
public class RegistrationValidation extends HttpServlet implements RegistrationForm, TableUsersNames {
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
		Connection connectionDB = null;
		try {
			connectionDB = Conector.getInstance().getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String username = request.getParameter(usernameInputName);
		String firstName = request.getParameter(firstNameInputName);
		String lastName = request.getParameter(secondNameInputName);
		String email = request.getParameter(emailInputName);
		boolean isPasswordCorrect = passwordValidation(request.getParameter(passwordInputName),
				request.getParameter(passwordConfirmInputName), request, response);
		boolean isUsernameCorrect = usernameValidation(username, connectionDB, request, response);
		Date currentDate = new Date(new Date().getTime());
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		// int result = 0;

		Part filePart = request.getPart("image");
		// if (filePart != null) {
		// System.out.println(
		// "================== До тук всичко е ок
		// ------------------filePart------------filePart------------filePart---------");
		// } else {
		// System.out.println("filePart null
		// ***************************************************** filePart");
		// }
		if (!isPasswordCorrect && !isUsernameCorrect) {
			// System.out.println("================== До тук всичко е ок
			// ---------------------------------------------------");
			try {
				InputStream fileContent = filePart.getInputStream();
				String password = new Password().getSaltedHash(passwordInputName);
				connectionDB = Conector.getInstance().getConnection();

				PreparedStatement pre = connectionDB.prepareStatement(
						"INSERT INTO `recipes_site`.`users` (`username`, `password`, `first_name`, `last_name`, `email`, `date_of_registration`, `gender`, `image`, `image_name`) VALUES (?,?,?,?,?,?,?,?,?);");
				pre.setString(1, username);
				pre.setString(2, password);
				pre.setString(3, firstName);
				pre.setString(4, lastName);
				pre.setString(5, email);
				pre.setDate(6, sqlDate);
				pre.setString(7, "who cares");
				pre.setBlob(8, fileContent);
				pre.setString(9, "" + username + "_image");
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
		}
		out.close();
	}

	private boolean passwordValidation(String passwordOne, String passwordTwo, HttpServletRequest request,
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
				return false;
			}
		}
		return true;
	}

	private Boolean usernameValidation(String username, Connection connectionDB, HttpServletRequest request,
			HttpServletResponse response) {
		ResultSet results = null;
		Statement statement;
		String query = "SELECT * FROM " + databaseName + "." + tableUsersName + " where " + tableUsersUsername + "='"
				+ username + "'";
		try {
			connectionDB = Conector.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				request.setAttribute("usernameCheck", "<div class=\"error\" >Потребителското име вече съшествува.</div>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			}
			return false;
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

}
