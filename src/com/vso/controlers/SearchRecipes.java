package com.vso.controlers;

import java.io.IOException;
import java.io.Serializable;
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
 * Servlet implementation class SearchRecipes
 */
@WebServlet("/SearchRecipes")
public class SearchRecipes extends HttpServlet
		implements TableRecipesNames, TableUsersNames, TableUserMap, FormSearchRecipe, TableCategoriesMapNames {
	private static final long serialVersionUID = 1L;
	private int categorySearch = 3;
	private int allCategories = 3;
	private int vegetarianCategory = 2;
	private int vegenCategory = 1;
	private String radioAllChecked = "checked=\"checked\"";
	private String radioVegetarianChecked = "";
	private String radioVeganChecked = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchRecipes() {
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
			System.out.println("radioValue========================================= " + radioValue);
		} catch (Exception e) {
		}
		ArrayList<String> listIds = new ArrayList<String>();
		ArrayList<String> listRecpeNames = new ArrayList<String>();
		Connection connectionDB = null;
		PreparedStatement prStatement = null;
		ResultSet results = null;
		String queryCountResults = searchFor + "%';";
		String query = queryGetSearchPartly + searchFor + "%' ORDER BY id DESC LIMIT " + (startNumber - 1) + ","
				+ showPerPage + ";";
		try {

			connectionDB = ConnectorDB.getInstance().getConnection();
			prStatement = connectionDB.prepareStatement(query);
			results = prStatement.executeQuery(query);
			int enter = 1;
			while (results.next()) {
				System.out.println("-----===============================----------влизане " + enter + " showPerPage - "
						+ showPerPage);
				if (categorySearch == 3) {
					System.out.println(" ----------------------------Всички рецепти запис -------------------");
					listIds.add(results.getString(tableRecipesColumnID));
					listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
				} else {
					if (isCategory(results.getString(tableRecipesColumnID))) {
						System.out.println("веган-вегетариан ------------------------ намерен!");
						listIds.add(results.getString(tableRecipesColumnID));
						listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
					}
				}
				enter++;
			}
			System.out.println(listIds.size());
			System.out.println(listRecpeNames.size());
			request.setAttribute(formSearchStartNumber, startNumber);
			request.setAttribute(formSearchShowPerPage, showPerPage);
			request.setAttribute(formSearchSearchInputName, searchFor);
			request.setAttribute(formSearchColumnsNumber, columns);
			request.setAttribute("ids", listIds);
			request.setAttribute("names", listRecpeNames);
			request.setAttribute(formSearchRecpeAllRecipesNumber, getRowsNumber(searchFor));
			request.setAttribute(formSearchRadioCheckedAll, radioAllChecked);
			request.setAttribute(formSearchRadioCheckedVegetarian, radioVegetarianChecked);
			request.setAttribute(formSearchRadioCheckedVegan, radioVeganChecked);
			prStatement.close();
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
			radioAllChecked = "checked=\"checked\"";
			radioVegetarianChecked = "";
			radioVeganChecked = "";
			categorySearch = allCategories;
		} else if (radioValue.equals("вегетариански")) {
			radioAllChecked = "";
			radioVegetarianChecked = "checked=\"checked\"";
			radioVeganChecked = "";
			categorySearch = vegetarianCategory;
		} else {
			radioAllChecked = "";
			radioVegetarianChecked = "";
			radioVeganChecked = "checked=\"checked\"";
			categorySearch = vegenCategory;
		}
	}

	private int getRowsNumber(String queryParameters) {
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		String query = "SELECT COUNT(*) AS count FROM `recipes_site`.`recipes` WHERE `name` LIKE '%" + queryParameters + "%';";
		System.out.println(query);
		int rowsNumber = 0;
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				rowsNumber = results.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsNumber;
	}

	private String getRecipeName(String name) {
		if (name.length() > 33) {
			String namePart = name.substring(0, 30) + "...";
			return namePart;
		} else {
			return name;
		}
	}
}
