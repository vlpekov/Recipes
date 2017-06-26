package com.vso.controlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.database.utilities.Conector;
import com.vso.interfaces.FormNamesNewRecipe;
import com.vso.interfaces.FormNamesRegistration;
import com.vso.interfaces.TableProductsNames;
import com.vso.interfaces.TableRecipesNames;
import com.vso.interfaces.TableUsersNames;
import com.vso.models.Password;

/**
 * Servlet implementation class RecipeSave
 */
@WebServlet("/RecipeSave")
public class RecipeSave extends HttpServlet implements FormNamesNewRecipe, TableProductsNames,  TableRecipesNames {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				System.out.println("RegistrationValidation.class hashed password: " + password);
				connectionDB = Conector.getInstance().getConnection();
				PreparedStatement pre = connectionDB.prepareStatement(
						"INSERT INTO `" + databaseName + "`.`" + tableUsersName + "` (`" + tableUsersColumnUsername + "`, `" + tableUsersColumnPassword + "`, `" + tableUsersColumnFirstName + "`, `" + tableUsersColumnLastName + "`, `" + tableUsersColumnEmail + "`, `" + tableUsersColumnRegistrationDate + "`, `" + tableUsersColumnGender + "`, `" + tableUsersColumnProfilPictureFile + "`, `" + tableUsersColumnProfilPictureName + "`) VALUES (?,?,?,?,?,?,?,?,?);");
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		}
		out.close();
	}

}
