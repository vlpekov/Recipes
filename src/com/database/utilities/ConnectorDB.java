package com.database.utilities;

import java.sql.*;

public class ConnectorDB {

	private static String databaseURL = "jdbc:mysql://localhost";
	private static String databasePort = "3306";
	private static String dbName = "recipes_site";
	private static String user = "root";
	private static String password = "asxz16";
	private static ConnectorDB instance = new ConnectorDB();
	private String url = "" + databaseURL + ":" + databasePort + "/" + dbName + "";

	private ConnectorDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectorDB getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
//	Connection connectionDB = Conector.getInstance().getConnection();
//	Statement statement = connectionDB.createStatement();

}
