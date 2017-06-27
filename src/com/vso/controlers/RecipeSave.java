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
import javax.servlet.http.Cookie;
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
import com.javabeans.CookiesManager;;

/**
 * Servlet implementation class RecipeSave
 */
@WebServlet("/RecipeSave")
@javax.servlet.annotation.MultipartConfig
public class RecipeSave extends HttpServlet implements FormNamesNewRecipe, TableProductsNames, TableRecipesNames {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeSave() {
		super();
		// TODO Auto-generated constructor stub
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
		loginCheck(request, response);
		PrintWriter out = response.getWriter();
		Connection connectionDB = null;

		String recipeName = request.getParameter("test");
		String cookingDescription = request.getParameter(cookingDescriptionInputName);
		String cookingTime = request.getParameter(timeInputName);
		String difficulty = request.getParameter(difficultyInputName);
		String[] productsList = request.getParameter("hiddenProductsField").split("\\$");
		String[] quantitiesList = request.getParameter("hiddenQuantitiesField").split("\\$");
		String portions = request.getParameter(portionsInputName);
		// Part filePart = request.getPart(imageInputName);
		// InputStream fileContent = filePart.getInputStream();
		
		System.out.println(cookingDescription);
		System.out.println(cookingTime);
		System.out.println(difficulty);
		System.out.println(portions);
		for (String product : productsList) {
			System.out.println(product);
		}
		for (String quantity : quantitiesList) {
			System.out.println(quantity);
		}
		// for (String quantity : quantities){
		// System.out.println(quantity);
		// }
		// connectionDB = Conector.getInstance().getConnection();
		// PreparedStatement pre = connectionDB.prepareStatement("INSERT INTO `"
		// + databaseName + "`.`" + tableUsersName
		// + "` (`" + tableUsersColumnUsername + "`, `" +
		// tableUsersColumnPassword + "`, `"
		// + tableUsersColumnFirstName + "`, `" + tableUsersColumnLastName + "`,
		// `" + tableUsersColumnEmail
		// + "`, `" + tableUsersColumnRegistrationDate + "`, `" +
		// tableUsersColumnGender + "`, `"
		// + tableUsersColumnProfilPictureFile + "`, `" +
		// tableUsersColumnProfilPictureName
		// + "`) VALUES (?,?,?,?,?,?,?,?,?);");
		// pre.setString(1, username);
		// pre.setString(2, password);
		// pre.setString(3, firstName);
		// pre.setString(4, lastName);
		// pre.setString(5, email);
		// pre.setDate(6, sqlDate);
		// pre.setString(7, "who cares");
		// pre.setBlob(8, fileContent);
		// pre.setString(9, "" + username + "_image");
		// pre.executeUpdate();
		// pre.close();
		request.setAttribute("recordSuccess",
				"<h1>Поздравления<br>Регистрирахте се успешно.<br>Може да се впишете:</h1>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("signin");
		dispatcher.include(request, response);
		out.close();
	}

	private void loginCheck(HttpServletRequest request, HttpServletResponse response) {
		boolean isLoggedIn;
		Cookie[] cookies = request.getCookies();
		isLoggedIn = new CookiesManager().isUserCorrect(cookies);
		if (isLoggedIn) {
			try {
				response.sendRedirect("login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
