package com.vso.controlers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.utilities.ConnectorDB;
import com.vso.interfaces.TableUsersNames;

/**
 * Servlet implementation class GetUserProfile
 */
@WebServlet("/GetUserProfile")
public class GetUserProfile extends HttpServlet implements TableUsersNames {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserProfile() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");

		Connection connectionDB = null;
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			Statement statement = connectionDB.createStatement();
			String query = queryGetUserByUsername + username + "'";
			ResultSet results = statement.executeQuery(query);

			if (results.next()) {
				byte[] imgData = results.getBytes(tableUsersColumnProfilPictureFile);
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
