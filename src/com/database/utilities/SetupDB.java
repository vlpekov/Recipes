package com.database.utilities;

import java.sql.Connection; // a connection to the DB
import java.sql.DriverManager; // handles communication with the DB
import java.sql.PreparedStatement;
import java.sql.ResultSet; // a table of rows generated from an SQL query
import java.sql.ResultSetMetaData;
import java.sql.Statement; // an SQL statement for the DB to execute
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties; // key/value pairs

import com.vso.models.User;

public class SetupDB {

	private static Connection connectionDB;
	private static String databaseURL = "jdbc:mysql://localhost";
	private static String databasePort = "3306";
	private static String dbName = "recipes_site";
	private static String user = "root";
	private static String password = "asxz16";
	private static Statement connection;
	private static PreparedStatement preparedStatementConection;

	private SetupDB() {
		CreateDB.crateDatabase();
		connection = setDBConnection();
		CreateTables.CreateAllTables();
	}

	private static Statement setDBConnection() {
		try {
			String url = "" + databaseURL + ":" + databasePort + "/" + dbName + "";
			Properties loginDB = setLoginForDB();
			Class.forName("com.mysql.jdbc.Driver");
			connectionDB = DriverManager.getConnection(url, loginDB);
			Statement state = connectionDB.createStatement();
			System.out.println("Connection established: " + !connectionDB.isClosed());
			System.out.println("Connection statement: " + !state.isClosed());
			return (Statement) state;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	private static Properties setLoginForDB() {
		Properties loginData = new Properties();
		loginData.setProperty("user", user);
		loginData.setProperty("password", password);
		return loginData;
	}

	private static class managerHolder {
		private final static SetupDB instance = new SetupDB();
	}

	public static SetupDB getInstance() {
		try {
			return managerHolder.instance;
		} catch (ExceptionInInitializerError ex) {
			System.out.println("ExceptionInInitializerError");
		}
		return null;
	}

	public static Statement getStatement() {
		return connection;
	}

	public static Connection getConnection() {
		return connectionDB;
	}
	
	public static String getPassword() {
		return password;
	}

	public static String getUsername() {
		return user;
	}

	public static String getDbName() {
		return dbName;
	}

	public static String getdatabaseURL() {
		return databaseURL;
	}

	// ConnectionDB single = ConnectionDB.getInstance();
	// Statement state = ConnectionDB.getStatement();
	// /* put your SQL code in the variable sqlString */
	// String sqlString = "";
	// ResultSet result = state.executeQuery(sqlString);

}