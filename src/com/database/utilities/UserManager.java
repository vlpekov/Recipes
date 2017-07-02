package com.database.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vso.interfaces.TableUsersNames;
import com.vso.models.Password;

public class UserManager implements TableUsersNames {
	
	public String getUserPasswordFromDB(String username) {
		ResultSet results = null;
		Connection connectionDB;
		String password = null;
		String dbPassword = null;
		String query = queryGetUserByUsername + username + "';";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			Statement statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				dbPassword = results.getString("password");
			}
			return dbPassword;
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
		return dbPassword;
	}
}
