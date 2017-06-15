package com.database.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDB_backup {
	private Connection connectionDB;
	private String databaseURL = "jdbc:mysql://localhost";
	private String databasePort = "3306";
	private static String dbName = "RecipesSite";
	private final String user = "root";
	private static String password = "asxz16";
    private static Statement connection;

	private CreateDB_backup() {
		crateDatabase();
		connection = setConnection();
	}
	
	public void crateDatabase() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=" + password);
			Statement createDbStatement = connect.createStatement();
			int Result = createDbStatement.executeUpdate("CREATE DATABASE " + dbName + ";");
			String crateTable = "CREATE TABLE `" + dbName + "`.`users` (" + "id SERIAL PRIMARY KEY NOT NULL,"
					+ "username TEXT NOT NULL," + "password TEXT NOT NULL," + "first_name TEXT NOT NULL,"
					+ "last_name TEXT NOT NULL," + "email TEXT NOT NULL," + "date_of_registration DATE NOT NULL,"
					+ "gender TEXT NOT NULL, is_remember INT NOT NULL);";
			createDbStatement.executeUpdate(crateTable);
			connect.close();
			createDbStatement.close();
		} catch (Exception e) {

		}

	}
}
