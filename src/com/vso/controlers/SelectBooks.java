package com.vso.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.utilities.*;
import com.vso.models.*;

/**
 * Servlet implementation class SelectBooks
 */
@WebServlet("/SelectBooks")
public class SelectBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection connectionDB;
	static String dbName = SetupDB.getDbName();
	static String password = SetupDB.getPassword();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectBooks() {
		new SetupDB();
		setupDBConnection();
	}

	public void setupDBConnection() {

		try {
			String uri = "jdbc:mysql://localhost:3306/" + dbName + "?autoReconnect=true&relaxAutoCommit=true";
			Properties loginDB = setLoginForDB();
			Class.forName("com.mysql.jdbc.Driver");
			connectionDB = DriverManager.getConnection(uri, loginDB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Properties setLoginForDB() {
		Properties loginData = new Properties();
		loginData.setProperty("user", "root");
		loginData.setProperty("password", password);
		return loginData;
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
		// PrintWriter out = response.getWriter();
		String searchForName = request.getParameter("book_name");
		List<Book> books = new ArrayList<Book>();
		books = getBookByName(searchForName);
		request.setAttribute("bookList", books);
		request.setAttribute("searchFor", searchForName);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsps/Results.jsp");
		view.forward(request, response);

	}

	public List<Book> getBookByName(String bookName) {
		List<Book> books = new ArrayList<>();
		try {
			Statement stmt = connectionDB.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM books WHERE name LIKE '%" + bookName + "%';");
			while (results.next()) {
				Book currentBook = new Book();
				int id = results.getInt("id");
				String name = results.getString("name");
				String bookAuthor = results.getString("author");
				String bookIsbn = results.getString("isbn");
				Date dateOfPublishing = results.getDate("date_of_publishing");
				boolean isBooked = results.getInt("is_booked") != 0;

				currentBook.setId(id);
				currentBook.setName(name);
				currentBook.setBookAuthor(bookAuthor);
				currentBook.setBookIsbn(bookIsbn);
				currentBook.setDateOfPublishing(dateOfPublishing);
				currentBook.setBooked(isBooked);
				books.add(currentBook);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	private void print(List<Book> books) {
		for (Book book : books) {
			System.out.println(book.getName());
		}
	}
}
