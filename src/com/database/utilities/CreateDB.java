package com.database.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDB {


	public CreateDB() {
		crateDatabase();
	}

	public static void crateDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager
					.getConnection("" + SetupDB.getdatabaseURL() + "/?user=" + SetupDB.getUsername() + "&password=" + SetupDB.getPassword());
			Statement createDbStatement = connect.createStatement();
			int Result = createDbStatement.executeUpdate("CREATE DATABASE " + SetupDB.getDbName() + ";");
			System.out.println("Database created");
			connect.close();
			createDbStatement.close();
		} catch (Exception e) {
			System.out.println("The database already exists.");
		}

	}
}
