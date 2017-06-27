package com.vso.controlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.FormNamesNewRecipe;
import com.vso.interfaces.FormNamesRegistration;
import com.vso.interfaces.TableProductsMapNames;
import com.vso.interfaces.TableProductsNames;
import com.vso.interfaces.TableRecipesNames;
import com.vso.interfaces.TableUsersNames;
import com.vso.models.Password;
import com.vso.models.Recipe;
import com.javabeans.CookiesManager;;

/**
 * Servlet implementation class RecipeSave
 */
@WebServlet("/RecipeSave")
@javax.servlet.annotation.MultipartConfig
public class RecipeSave extends HttpServlet
		implements FormNamesNewRecipe, TableProductsNames, TableRecipesNames, TableProductsMapNames {
	private static final long serialVersionUID = 1L;
	
	int vegan = 1;
	int vegeterian = 2;
	int meat = 3;
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

		String recipeName = request.getParameter(recipeTitleInputName);
		String cookingDescription = request.getParameter(cookingDescriptionInputName);
		String cookingTime = request.getParameter(timeInputName);
		String difficulty = request.getParameter(difficultyInputName);
		String[] productsList = request.getParameter("hiddenProductsField").split("\\$");
		String[] quantitiesList = request.getParameter("hiddenQuantitiesField").split("\\$");
		String portions = request.getParameter(portionsInputName);
		Date currentDate = new Date(new Date().getTime());
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		// Part filePart = request.getPart(imageInputName);
		// InputStream fileContent = filePart.getInputStream();

		for (String product : productsList) {
			System.out.println(product);
		}
		for (String quantity : quantitiesList) {
			System.out.println(quantity);
		}
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			PreparedStatement pre = connectionDB.prepareStatement(queryNewRecipeRecord);
			pre.setString(1, recipeName);
			pre.setString(2, cookingDescription);
			pre.setDate(3, sqlDate);
			pre.setString(4, cookingTime);
			pre.setString(5, difficulty);
			pre.setString(6, portions);
			pre.executeUpdate();
			pre.close();
			request.setAttribute("recipeRecordSuccess", "<h1>Рецептата е записана успешно.</h1>");
			
			Recipe thisRecipe = new Recipe(recipeName);
			PreparedStatement preProducts = connectionDB.prepareStatement(queryNewProductsMapRecord);
			int recipeCategory = vegan;
			for (int index = 0; index < productsList.length; index++) {
				preProducts.setInt(1, getProductId(productsList[index], connectionDB));
				preProducts.setInt(2, thisRecipe.getId());
				preProducts.setInt(3, Integer.parseInt(quantitiesList[index]));
				preProducts.executeUpdate();
				if (recipeCategory != meat) {
					
				}
			}
			preProducts.close();
			request.setAttribute("productsRecordSuccess", "<h1>Продуктите са записана успешно.</h1>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	private int getProductId(String productName, Connection connectionDB) {
		String query = queryGetProductByName + productName + "'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				return results.getInt(tableProductsColumnId);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}