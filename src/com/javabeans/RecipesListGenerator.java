package com.javabeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.database.utilities.*;
import com.vso.interfaces.TableRecipesNames;

public class RecipesListGenerator implements Serializable, TableRecipesNames {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listRecpeNames = new ArrayList<String>();
	
	public ArrayList<String> getFullList() {
		ArrayList<String> listIds = new ArrayList<String>();
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		String query = queryGetFullList;
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			while (results.next()) {
				listIds.add(tableRecipesColumnID);
				listRecpeNames.add(tableRecipesColumnRecipeName);
			}
			statement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIds;
	}

	public ArrayList<String> getListRecpeNames() {
		return listRecpeNames;
	}
	
	
}
