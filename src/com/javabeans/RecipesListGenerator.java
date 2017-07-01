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
import com.vso.interfaces.TableUserMap;
import com.vso.interfaces.TableUsersNames;

public class RecipesListGenerator implements Serializable, TableRecipesNames, TableUsersNames, TableUserMap {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listRecpeNames = new ArrayList<String>();

	// public ArrayList<String> getFullList() {
	// ArrayList<String> listIds = new ArrayList<String>();
	// Connection connectionDB = null;
	// Statement statement = null;
	// ResultSet results = null;
	// String query = queryGetFullList;
	// try {
	// connectionDB = ConnectorDB.getInstance().getConnection();
	// statement = connectionDB.createStatement();
	// results = statement.executeQuery(query);
	// while (results.next()) {
	// listIds.add(results.getString(tableRecipesColumnID));
	//
	// listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
	// }
	// statement.close();
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return listIds;
	// }

	public ArrayList<String> getListRecpeNames() {
		return listRecpeNames;
	}

	public ArrayList<String> getListPartly(int startNumber, int showPerPage) {
		ArrayList<String> listIds = new ArrayList<String>();
		Connection connectionDB = null;
		PreparedStatement prStatement = null;
		ResultSet results = null;
		String query = queryGetAllOrderByDateDesc + " LIMIT " + (startNumber - 1) + "," + showPerPage + ";";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			prStatement = connectionDB.prepareStatement(query);
			results = prStatement.executeQuery(query);
			while (results.next()) {
				listIds.add(results.getString(tableRecipesColumnID));
				listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
				System.out.println(results.getString(tableRecipesColumnID) + " ---- "
						+ getRecipeName(results.getString(tableRecipesColumnRecipeName)));
			}
			prStatement.close();
		} catch (Exception e) {
		}
		return listIds;
	}

	// public ArrayList<String> getListPartlyOrderByDesc(int startNumber, int
	// showPerPage) {
	// ArrayList<String> listIds = new ArrayList<String>();
	// Connection connectionDB = null;
	// PreparedStatement prStatement = null;
	// ResultSet results = null;
	// String query = queryGetAllOrderByDateDesc + " LIMIT " + (startNumber - 1)
	// + "," + showPerPage + ";";
	// System.out.println(query);
	// try {
	// connectionDB = ConnectorDB.getInstance().getConnection();
	// prStatement = connectionDB.prepareStatement(query);
	// results = prStatement.executeQuery(query);
	// while (results.next()) {
	// listIds.add(results.getString(tableRecipesColumnID));
	// listRecpeNames.add(getRecipeName(results.getString(tableRecipesColumnRecipeName)));
	// }
	// prStatement.close();
	// } catch (Exception e) {
	// }
	// return listIds;
	// }
	//
	public ArrayList<String> getUserRecipesListPartly(int startNumber, int showPerPage, String username) {
		ArrayList<String> listIds = new ArrayList<String>();
		Connection connectionDB = null;
		PreparedStatement prStatement = null;
		ResultSet results = null;
		String query = queryGetRecipeIdByUserId + getUserId(username) + "'" + " LIMIT " + (startNumber - 1) + ","
				+ showPerPage + ";";
		System.out.println(query);
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			prStatement = connectionDB.prepareStatement(query);
			results = prStatement.executeQuery(query);
			while (results.next()) {
				listIds.add(results.getString(tableUserMapColumnRecipeId));
				listRecpeNames.add(getRecipeById(results.getInt(tableUserMapColumnRecipeId)));
				System.out.println("========================== getRecipeById =================" + results.getString(tableRecipesColumnID) + " === " + getRecipeById(results.getInt(tableRecipesColumnID)));
			}
			prStatement.close();
		} catch (Exception e) {
		}
		return listIds;
	}

	public int getUserId(String username) {
		String query = queryGetUserByUsername + username + "'";
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		int userId = 0;
		System.out.println(query);
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.prepareStatement(query);
			results = statement.executeQuery(query);
			if (results.next()) {
				userId = results.getInt(tableUsersColumnId);
			}
			statement.close();
		} catch (Exception e) {
		}
		return userId;
	}

	public int getRowsNumber() {
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		int rowsNumber = 0;
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(queryGetRecipesNumber);
			if (results.next()) {
				rowsNumber = results.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsNumber;
	}

	private String getRecipeName(String name) {
		if (name.length() > 33) {
			String namePart = name.substring(0, 30) + "...";
			return namePart;
		} else {
			return name;
		}
	}

	private String getRecipeById(int recipeId) {
		String name = "";
		Connection connectionDB = null;
		Statement statement = null;
		ResultSet results = null;
		String query = queryGetRecipeById + recipeId + "'";
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				name = results.getString(tableRecipesColumnRecipeName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (name.length() > 33) {
			String namePart = name.substring(0, 30) + "...";
			return namePart;
		} else {
			return name;
		}
	}
}
