package com.vso.controlers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.TableImages;

/**
 * Servlet implementation class GetRecipePicture
 */
@WebServlet("/GetRecipePicture")
public class GetRecipePicture extends HttpServlet implements TableImages {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetRecipePicture() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String recipeId = request.getParameter("recipeId");
		Connection connectionDB = null;
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			Statement statement = connectionDB.createStatement();
			String query = queryGetImageByRecipeId + recipeId + "'";
			ResultSet results = statement.executeQuery(query);
			if (results.next()) {
				byte[] imgData = results.getBytes(tableImagesColumnImageFile);
				response.setHeader("expires", "0");
				response.setContentType("image/jpg");
				OutputStream output = response.getOutputStream(); 
				output.write(imgData);
				output.flush();
				output.close();
			}
			statement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}