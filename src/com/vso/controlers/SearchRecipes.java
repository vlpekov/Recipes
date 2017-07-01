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
import com.vso.interfaces.TableRecipesNames;
import com.vso.interfaces.TableUserMap;
import com.vso.interfaces.TableUsersNames;

/**
 * Servlet implementation class SearchRecipes
 */
@WebServlet("/SearchRecipes")
public class SearchRecipes extends HttpServlet
		implements TableRecipesNames, TableUsersNames, TableUserMap, FormSearchRecipe {
	private static final long serialVersionUID = 1L;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

		ArrayList<String> listIds = new ArrayList<String>();
		ArrayList<String> listRecpeNames = new ArrayList<String>();
		Connection connectionDB = null;
		PreparedStatement prStatement = null;
		ResultSet results = null;
		String queryCountResults = searchFor + "%';";
		String query = queryGetSearchPartly + searchFor + "%' ORDER BY id DESC LIMIT " + (startNumber - 1) + "," + showPerPage + ";";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			prStatement = connectionDB.prepareStatement(query);
			results = prStatement.executeQuery(query);
			while (results.next()) {
				listIds.add(results.getString(tableRecipesColumnID));
				listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
				System.out.println(results.getString(tableRecipesColumnID) + " --doPost-- "
						+ getRecipeName(results.getString(tableRecipesColumnRecipeName)));
			}
			System.out.println(listIds.size());
			System.out.println(listRecpeNames.size());
			request.setAttribute(formSearchStartNumber, startNumber);
			request.setAttribute(formSearchShowPerPage, showPerPage);
			request.setAttribute(formSearchSearchInputName, searchFor);
			request.setAttribute(formSearchColumnsNumber, columns);
			request.setAttribute("ids", listIds);
			request.setAttribute("names", listRecpeNames);
			request.setAttribute(formSearchRecpeAllRecipesNumber, getRowsNumber(queryCountResults));
			
			prStatement.close();
//			request.getRequestDispatcher("search_results").forward(request, response);
		} catch (Exception e) {
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("search_results");
		dispatcher.include(request, response);
		doGet(request, response);
	}

	private int getRowsNumber(String queryParameters) {
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		String query = "SELECT COUNT(*) AS count FROM `recipes_site`.`recipes` WHERE `name` LIKE '%тор%';";
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
