package com.vso.controlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.FormSearchRecipe;
import com.vso.interfaces.TableCategoriesMapNames;
import com.vso.interfaces.TableRecipesNames;
import com.vso.interfaces.TableUserMap;
import com.vso.interfaces.TableUsersNames;

/**
 * Servlet implementation class ShowByCategory
 */
@WebServlet("/ShowByCategory")
public class ShowByCategory extends HttpServlet
		implements TableRecipesNames, TableUsersNames, TableUserMap, FormSearchRecipe, TableCategoriesMapNames {
	private static final long serialVersionUID = 1L;
	private int categorySearch = 0;
	private int allCategories = 0;
	private int meaty = 3;
	private int vegetarianCategory = 2;
	private int vegenCategory = 1;
	private String radioMeatyChecked = "checked=\"checked\"";
	private String radioVegetarianChecked = "";
	private String radioVeganChecked = "";
	private String radioeAllChecked = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowByCategory() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int startNumber = Integer.parseInt(request.getParameter(formSearchStartNumber));
		int showPerPage = Integer.parseInt(request.getParameter(formSearchShowPerPage));
		String searchFor = request.getParameter(formSearchSearchInputName);
		int columns = Integer.parseInt(request.getParameter(formSearchColumnsNumber));
		String radioValue = "";
		try {
			radioValue = request.getParameter(formSearchRadioButtonName);
			setRadioValues(radioValue);
		} catch (Exception e) {
		}
		ArrayList<String> listIds = new ArrayList<String>();
		ArrayList<String> listRecpeNames = new ArrayList<String>();
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		String queryCountResults = queryGetRecipesNumberByCategory + categorySearch + "';";
		String queryGetAllCategories = queryGetAllOrderByDateDesc + " LIMIT " + (startNumber - 1) + "," + showPerPage + ";";
		String queryCategorySearch = queryGetCategoryByCategory + categorySearch + "' ORDER BY id DESC LIMIT "
				+ (startNumber - 1) + "," + showPerPage + ";";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			if (categorySearch == 0) {
				request.setAttribute(formSearchRecpeAllRecipesNumber, getRowsNumber(queryTableRecipesGetRecipesNumber));
				results = statement.executeQuery(queryGetAllCategories);
				while (results.next()) {
					listIds.add(results.getString(tableRecipesColumnID));
					listRecpeNames.add(results.getString(tableRecipesColumnRecipeName));
				}
			} else {
				request.setAttribute(formSearchRecpeAllRecipesNumber, getRowsNumber(queryCountResults));
				results = statement.executeQuery(queryCategorySearch);
				while (results.next()) {
					listIds.add(results.getString(tableCategoriesMapColumnRecipeId));
					listRecpeNames.add(getRecipeById(results.getInt(tableCategoriesMapColumnRecipeId)));
					
				}
			}
			request.setAttribute(formSearchStartNumber, startNumber);
			request.setAttribute(formSearchShowPerPage, showPerPage);
			request.setAttribute(formSearchSearchInputName, searchFor);
			request.setAttribute(formSearchColumnsNumber, columns);
			request.setAttribute("ids", listIds);
			request.setAttribute("names", listRecpeNames);
			request.setAttribute(formSearchRadioCheckedAll, radioeAllChecked);
			request.setAttribute(formSearchRadioCheckedVegetarian, radioVegetarianChecked);
			request.setAttribute(formSearchRadioCheckedVegan, radioVeganChecked);
			request.setAttribute(formSearchRadioCheckedMeaty, radioMeatyChecked);
			
			statement.close();
			// request.getRequestDispatcher("search_results").forward(request,
			// response);
		} catch (Exception e) {
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("search_results");
		dispatcher.include(request, response);
		doGet(request, response);
	}

	private boolean isCategory(String recipeId) {
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		String query = queryGetCategoryByRecipeId + recipeId + "'";
		System.out.println(query);
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				int categoryMap = results.getInt(tableCategoriesMapColumnCategoryId);
				if (categoryMap == categorySearch) {
					System.out.println("isCategoryisCategoryisCategoryisCategory ====== true");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("isCategoryisCategoryisCategoryisCategory ====== false");
		return false;
	}

	private void setRadioValues(String radioValue) {
		if (radioValue.equals("всички")) {
			categorySearch = allCategories;
			radioeAllChecked = "checked=\"checked\"";
			radioMeatyChecked = "";
			radioVegetarianChecked = "";
			radioVeganChecked = "";
		}
		if (radioValue.equals("месни")) {
			radioMeatyChecked = "checked=\"checked\"";
			radioVegetarianChecked = "";
			radioVeganChecked = "";
			radioeAllChecked = "";
			categorySearch = meaty;
		} else if (radioValue.equals("вегетариански")) {
			radioMeatyChecked = "";
			radioVegetarianChecked = "checked=\"checked\"";
			radioVeganChecked = "";
			radioeAllChecked = "";
			categorySearch = vegetarianCategory;
		} else if (radioValue.equals("веган")) {
			radioMeatyChecked = "";
			radioVegetarianChecked = "";
			radioeAllChecked = "";
			radioVeganChecked = "checked=\"checked\"";
			categorySearch = vegenCategory;
		}
	}

	private int getRowsNumber(String queryParameters) {
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		System.out.println(queryParameters);
		int rowsNumber = 0;
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(queryParameters);
			if (results.next()) {
				rowsNumber = results.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsNumber;
	}

	private String getRecipeById(int recipeId) {
		String name = "";
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		String query = queryGetRecipeById + recipeId + "'";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				name = results.getString(tableRecipesColumnRecipeName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (name.length() > 33) {
			String namePart = name.substring(0, 30) + "...";
			return namePart;
		} else {
			return name;
		}
	}
}
