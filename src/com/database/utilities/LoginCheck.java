package com.database.utilities;

import java.sql.Connection; // a connection to the DB
import java.sql.PreparedStatement;
import java.sql.ResultSet; // a table of rows generated from an SQL query
import java.sql.SQLException;
import java.sql.Statement;
import com.vso.models.Password;

public class LoginCheck {

	SetupDB single = SetupDB.getInstance();
	static Statement state = (Statement) SetupDB.getStatement();
	public static String usersTableName = "users";
	public static String usernameColumn = "username";
	public static String passwordColumn = "password";

	public static boolean validatePassword(String username, String password) {
		boolean status = false;
		ResultSet results = null;
		Connection connectionDB;
		String query = "SELECT * FROM " + SetupDB.getDbName() + "." + usersTableName + " where " + usernameColumn + "='"
				+ username + "';";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			Statement statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				String dbPassword = results.getString("password");
				status = Password.check(password, dbPassword);
			}
			return status;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (results != null) {
				try {
					results.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	public static String getPasswordFromDB(String username) {
		String dbPassword = null;
		Connection connectionDB;
		ResultSet results = null;
		Statement statement;
		String query = "SELECT * FROM " + SetupDB.getDbName() + "." + usersTableName + " where " + usernameColumn + "='"
				+ username + "'";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				dbPassword = results.getString("password");
			}
			return dbPassword;
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		return dbPassword;
	}
}
