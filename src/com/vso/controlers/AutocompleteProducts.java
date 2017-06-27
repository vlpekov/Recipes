package com.vso.controlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.Part;

import org.json.JSONArray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
 * Servlet implementation class AutocompleteProducts
 */
@WebServlet("/AutocompleteProducts")
public class AutocompleteProducts extends HttpServlet implements DatabaseNames, TableProductsNames {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutocompleteProducts() {
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
		ArrayList<String> productsList = new ArrayList<String>();
		String sqlCommand = "SELECT " + tableProductsColumnName + " FROM " + databaseName + "." + tableProducts + ";";
		try {
			Connection connectionDB = Conector.getInstance().getConnection();
			Statement statement = connectionDB.createStatement();
			ResultSet results = statement.executeQuery(sqlCommand);
			while (results.next()) {
				productsList.add(results.getString("name"));
			}
			results.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray json = new JSONArray(productsList);
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

}
