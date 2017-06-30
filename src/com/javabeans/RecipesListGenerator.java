package com.javabeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
				listIds.add(results.getString(tableRecipesColumnID));
				listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
			}
			statement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIds;
	}

	private String getRecipeName(String string) {
		if (string.length()>33) {
			String namePart = string.substring(0,30) + "...";
			return namePart;
		} else {
			return string;
		}
		
	}

	public ArrayList<String> getListRecpeNames() {
		return listRecpeNames;
	}

	public ArrayList<String> getListPartly(int startNumber, int showPerPage) {
		ArrayList<String> listIds = new ArrayList<String>();
		Connection connectionDB = null;
		PreparedStatement prStatement = null;
		ResultSet results = null;
		String query = queryGetPartList + (startNumber - 1) + "," + showPerPage + ";";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			prStatement = connectionDB.prepareStatement(query);
			results = prStatement.executeQuery(query);
			while (results.next()) {
				listIds.add(results.getString(tableRecipesColumnID));
				listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
			}

		} catch (Exception e) {
		}
		return listIds;
	}
}
