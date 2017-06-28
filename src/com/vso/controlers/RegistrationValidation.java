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
import com.database.utilities.ConnectorDB;
import com.vso.models.Password;
import com.vso.interfaces.*;

@WebServlet("/RegistrationValidation")
@MultipartConfig(maxFileSize = 16177216)
public class RegistrationValidation extends HttpServlet implements FormNamesRegistration, TableUsersNames {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection connectionDB = null;
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String username = request.getParameter(usernameInputName);
		String firstName = request.getParameter(firstNameInputName);
		String lastName = request.getParameter(lastNameInputName);
		String email = request.getParameter(emailInputName);
		request.setAttribute(usernameInputName, "value = \"" + username + "\"");
		request.setAttribute(firstNameInputName, "value = \"" + firstName + "\"");
		request.setAttribute(lastNameInputName, "value = \"" + lastName + "\"");
		request.setAttribute(emailInputName, "value = \"" + email + "\"");
		boolean isUsernameCorrect = usernameValidation(username, connectionDB, request, response);
		boolean isPasswordCorrect = true;
		if (isUsernameCorrect) {
			isPasswordCorrect = passwordValidation(request.getParameter(passwordInputName),
					request.getParameter(passwordConfirmInputName), request, response);
		}
		Date currentDate = new Date(new Date().getTime());
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		Part filePart = request.getPart("image");
		if (isPasswordCorrect && isUsernameCorrect) {
			try {
				InputStream fileContent = filePart.getInputStream();
				String password = new Password().getSaltedHash(request.getParameter(passwordInputName));
				connectionDB = ConnectorDB.getInstance().getConnection();
				PreparedStatement pre = connectionDB.prepareStatement(queryAddNewUser);
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
				request.setAttribute("registrationSuccess", "<h1>Поздравления<br>Регистрирахте се успешно.<br>Може да се впишете:</h1>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("signin");
				dispatcher.include(request, response);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("index.jsp");
		}
		out.close();
	}

	private boolean passwordValidation(String passwordOne, String passwordTwo, HttpServletRequest request,
			HttpServletResponse response) {
		if (passwordOne != "" && passwordTwo != "") {
			if (!passwordOne.equals(passwordTwo)) {
				request.setAttribute("status", "<div class=\"error\" >Грешно въведена парола.</div>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("register");
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

	private boolean usernameValidation(String username, Connection connectionDB, HttpServletRequest request,
			HttpServletResponse response) {
		ResultSet results = null;
		Statement statement;
		String query = "SELECT * FROM " + databaseName + "." + tableUsersName + " where " + tableUsersColumnUsername + "='"
				+ username + "'";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				request.setAttribute("usernameCheck",
						"<div class=\"error\" >Потребителското име вече съшествува.</div>");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("register");

				try {
					dispatcher.include(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return false;
			}
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

}
