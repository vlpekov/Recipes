package com.vso.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.DatabaseNames;
import com.vso.interfaces.TableRecipesNames;
import com.vso.interfaces.TableUsersNames;

public class User implements DatabaseNames, TableUsersNames {
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	java.sql.Date registrationDate;

	Connection connectionDB = null;

	public User(String username) {
		getDbConnection();
		this.username = username;
		getUserFromDbByName(this.username);
	}

	public User(int userId) {
		getDbConnection();
		this.userId = userId;
		getRecipeFromDbById(this.userId);
	}

	private void getDbConnection() {
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private void getUserFromDbByName(String username) {
		String query = queryGetUserByUsername + username + "'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				userId = results.getInt(tableUsersColumnId);
				password = results.getString(tableUsersColumnPassword);
				firstName = results.getString(tableUsersColumnFirstName);
				lastName = results.getString(tableUsersColumnLastName);
				email = results.getString(tableUsersColumnEmail);
				registrationDate = results.getDate(tableUsersColumnRegistrationDate);
				gender = results.getString(tableUsersColumnGender);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getRecipeFromDbById(int id) {
		String query = queryGetUserById + id + "'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			results = statement.executeQuery(query);
			if (results.next()) {
				username = results.getString(tableUsersColumnUsername);
				password = results.getString(tableUsersColumnPassword);
				firstName = results.getString(tableUsersColumnFirstName);
				lastName = results.getString(tableUsersColumnLastName);
				email = results.getString(tableUsersColumnEmail);
				registrationDate = results.getDate(tableUsersColumnRegistrationDate);
				gender = results.getString(tableUsersColumnGender);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getUserId() {
		return userId;
	}

	public java.sql.Date getRegistrationDate() {
		return registrationDate;
	}
}
