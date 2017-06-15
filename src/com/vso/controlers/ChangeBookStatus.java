package com.vso.controlers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.utilities.SetupDB;
import com.vso.models.User;

/**
 * Servlet implementation class ChangeBookStatus
 */
@WebServlet("/ChangeBookStatus")
public class ChangeBookStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final int free = 0;
	final int booked = 1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeBookStatus() {
		new SelectBooks();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("book_id"));

		changeStatus(bookId);
		int statusValue = getBookStatus(bookId);
		String bookAction = getBookAction(statusValue);
		String bookName = getBookName(bookId);
		String status = "Вие успешно " + bookAction + " книгата \"" + bookName + "\".";
		request.setAttribute("status", status);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsps/Status.jsp");
		view.forward(request, response);
	}

	public void changeStatus(int bookId) {
		int statusValue = getBookStatus(bookId);
		statusValue = invertStatus(statusValue);
		try {
			Statement statement = SelectBooks.connectionDB.createStatement();
			statement.executeUpdate("UPDATE " + SetupDB.getDbName() + ".`books` SET `is_booked`='" + statusValue
					+ "' WHERE `id`='" + bookId + "';");
			SelectBooks.connectionDB.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getBookStatus(int bookId) {
		int bookStatus = free;

		try {
			Statement statement = SelectBooks.connectionDB.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM books WHERE id = " + bookId + ";");
			if (results.next()) {
				bookStatus = results.getInt("is_booked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookStatus;
	}

	private String getBookName(int bookId) {

		try {
			Statement statement = SelectBooks.connectionDB.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM books WHERE id = " + bookId + ";");
			if (results.next()) {
				return results.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public int invertStatus(int statusValue) {
		if (statusValue == free) {
			return booked;
		} else {
			return free;
		}
	}

	public String getBookAction(int statusValue) {
		if (statusValue == free) {
			return "върнахте";
		} else {
			return "взехте";
		}
	}
}