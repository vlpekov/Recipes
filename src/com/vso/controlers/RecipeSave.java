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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.Cookies;
import com.vso.interfaces.FormNamesNewRecipe;
import com.vso.interfaces.TableCategories;
import com.vso.interfaces.TableCategoriesMapNames;
import com.vso.interfaces.TableImages;
import com.vso.interfaces.TableProductsMapNames;
import com.vso.interfaces.TableProductsNames;
import com.vso.interfaces.TableRecipesNames;
import com.vso.interfaces.TablesColumnNames;
import com.vso.models.Recipe;
import com.vso.models.User;
import com.javabeans.CookiesManager;;

@WebServlet("/RecipeSave")
@MultipartConfig(maxFileSize = 16177216)
public class RecipeSave extends HttpServlet implements FormNamesNewRecipe, Cookies, TablesColumnNames {
	private static final long serialVersionUID = 1L;

	int vegan = 1;
	int vegeterian = 2;
	int meaty = 3;

	public RecipeSave() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
		String newRecipeId = null;
		Date currentDate = new Date(new Date().getTime());
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		Part filePart = request.getPart(imageInputName);
		String user = "";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			PreparedStatement prStRecipe = connectionDB.prepareStatement(queryNewRecipeRecord);
			prStRecipe.setString(1, recipeName);
			prStRecipe.setString(2, cookingDescription);
			prStRecipe.setDate(3, sqlDate);
			prStRecipe.setString(4, cookingTime);
			prStRecipe.setString(5, difficulty);
			prStRecipe.setString(6, portions);
			prStRecipe.executeUpdate();
			prStRecipe.close();
			request.setAttribute("recipeRecordSuccess", "<h1>Рецептата е записана успешно.</h1>");
			getCategories(connectionDB);
			Recipe thisRecipe = new Recipe(recipeName);
			newRecipeId = "" + thisRecipe.getId();
			PreparedStatement prStProducts = connectionDB.prepareStatement(queryNewProductsMapRecord);
			int recipeCategory = vegan;
			for (int index = 0; index < productsList.length; index++) {
				prStProducts.setInt(1, getProductId(productsList[index], connectionDB));
				prStProducts.setInt(2, thisRecipe.getId());
				prStProducts.setInt(3, Integer.parseInt(quantitiesList[index]));
				prStProducts.executeUpdate();
				if (recipeCategory != meaty) {
					if (categryVegetarian.equals(getProductCategory(productsList[index], connectionDB))) {
						recipeCategory = vegeterian;
					}
				}
			}
			prStProducts.close();

			PreparedStatement prStCategoryMap = connectionDB.prepareStatement(queryNewCategoriesMapRecord);
			prStCategoryMap.setInt(1, thisRecipe.getId());
			prStCategoryMap.setInt(2, recipeCategory);
			prStCategoryMap.executeUpdate();
			prStCategoryMap.close();
			request.setAttribute("productsRecordSuccess", "<h1>Продуктите са записана успешно.</h1>");
			InputStream fileContent = filePart.getInputStream();

			PreparedStatement prStImage = connectionDB.prepareStatement(queryNewImageRecord);
			prStImage.setBlob(1, fileContent);
			prStImage.setString(2, "image_recipe" + thisRecipe.getId());
			prStImage.setInt(3, thisRecipe.getId());
			prStImage.executeUpdate();
			prStImage.close();

			User currentUser = new User(getUser(request, response));
			PreparedStatement prStUserMap = connectionDB.prepareStatement(queryNewUsersMapRecord);
			prStUserMap.setInt(1, thisRecipe.getId());
			prStUserMap.setInt(2, currentUser.getUserId());
			prStUserMap.executeUpdate();
			prStUserMap.close();
			thisRecipe.getProductsList();
			request.setAttribute(tableUsersColumnUsername, currentUser.getUsername());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getRecipe?recipeId=" + newRecipeId);
		dispatcher.include(request, response);
		
		out.close();
		
	}

	private String getProductCategory(String productName, Connection connectionDB) {
		String query = queryGetProductByName + productName + "'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				return results.getString(tableProductsColumnGroup);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void getCategories(Connection connectionDB) {
		Statement statement = null;
		ResultSet results = null;
		String query = queryGetCategoryIDByName + categryVegan + "'";
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				vegan = results.getInt(tableCategoriesColumnId);
			}
			query = queryGetCategoryIDByName + categryVegetarian + "'";
			results = statement.executeQuery(query);
			if (results.next()) {
				vegeterian = results.getInt(tableCategoriesColumnId);
			}
			query = queryGetCategoryIDByName + categryMeaty + "'";
			results = statement.executeQuery(query);
			if (results.next()) {
				meaty = results.getInt(tableCategoriesColumnId);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void loginCheck(HttpServletRequest request, HttpServletResponse response) {
		boolean isLoggedIn;
		Cookie[] cookies = request.getCookies();
		isLoggedIn = new CookiesManager().isUserCorrect(cookies);
		if (!isLoggedIn) {
			try {
				response.sendRedirect("login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String getUser(HttpServletRequest request, HttpServletResponse response) {
		String username = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals(cookieUsername)) {
				username = cookie.getValue();
				return username;
			}
		}
		return username;
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

	@Override
	public Cookie createCookie(String CookieName, String CookieData) {
		return null;
	}

	@Override
	public Cookie deleteCookie(String CookieName) {
		return null;
	}

}