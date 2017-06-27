package com.vso.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.*;

public class Recipe implements DatabaseNames, TableRecipesNames {
	int id;
	String recipeName;
	String cookingDescription;
	String cookingTime;
	String difficulty;
	String[] productsList;
	String[] quantitiesList;
	String portions;
	java.sql.Date publishingDate;
	Connection connectionDB = null;

	public Recipe(String recipeName) {
		getDbConnection();
		this.recipeName = recipeName;
		getRecipeFromDb(this.recipeName);

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

	public void getRecipeFromDb(String recipeName) {
		String query = queryGetRecipeByName + recipeName + "'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			results = statement.executeQuery(query);
			if (results.next()) {
				id = results.getInt(tableRecipesColumnID);
				cookingDescription = results.getString(tableRecipesColumnRecipeDescription);
				cookingTime = results.getString(tableRecipesColumnCookingTime);
				difficulty = results.getString(tableRecipesColumnDifficulty);
				portions = results.getString(tableRecipesColumnPortions);
				publishingDate = results.getDate(tableRecipesColumnPublishingDate);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getCookingDescription() {
		return cookingDescription;
	}

	public void setCookingDescription(String cookingDescription) {
		this.cookingDescription = cookingDescription;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String[] getProductsList() {
		return productsList;
	}

	public void setProductsList(String[] productsList) {
		this.productsList = productsList;
	}

	public String[] getQuantitiesList() {
		return quantitiesList;
	}

	public void setQuantitiesList(String[] quantitiesList) {
		this.quantitiesList = quantitiesList;
	}

	public String getPortions() {
		return portions;
	}

	public void setPortions(String portions) {
		this.portions = portions;
	}

	public java.sql.Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(java.sql.Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	
	
	

}