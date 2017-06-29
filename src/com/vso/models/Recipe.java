package com.vso.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.*;

public class Recipe implements DatabaseNames, TablesColumnNames {
	int id;
	String recipeName;
	String cookingDescription;
	String cookingTime;
	String difficulty;
	String[] productsList;
	String[] quantitiesList;
	String category;
	String portions;
	String htmlProductsTable;
	java.sql.Date publishingDate;
	Connection connectionDB = null;

	public Recipe(String recipeName) {
		getDbConnection();
		this.recipeName = recipeName;
		getRecipeFromDbByName(this.recipeName);
	}

	public Recipe(int recipeId) {
		getDbConnection();
		this.id = recipeId;
		getRecipeFromDbById(this.id);
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
	

	private void getDbConnection() {
		try {
			connectionDB = ConnectorDB.getInstance().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getRecipeFromDbByName(String recipeName) {
		String query = queryGetRecipeByName + recipeName + "'";
		Statement statement = null;
		ResultSet results = null;
		int productNumber = 0;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				id = results.getInt(tableRecipesColumnID);
				cookingDescription = results.getString(tableRecipesColumnRecipeDescription);
				cookingTime = results.getString(tableRecipesColumnCookingTime);
				difficulty = results.getString(tableRecipesColumnDifficulty);
				portions = results.getString(tableRecipesColumnPortions);
				publishingDate = results.getDate(tableRecipesColumnPublishingDate);
			}
			String productsQuery = queryGetProductsByRecipeId + id + "'";
			results = statement.executeQuery(productsQuery);
			while (results.next()) {
				Product product = new Product(results.getInt(tableProductsMapColumnProductId));
				productsList[productNumber] = product.getProductName();
				quantitiesList[productNumber] = results.getString(tableProductsMapColumnQuantity);
				productNumber++;
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void getRecipeFromDbById(int id) {
		String query = queryGetRecipeById + id + "'";
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
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void generateHTMLProductsTable() {
		htmlProductsTable = "<table><tr><th>Продукт:</th><th>Количество</th><th>Мярка</th></tr>";
		for (int index = 0; index < productsList.length; index++) {
			htmlProductsTable += "<tr><td>" + productsList[index] + "</td><td>" + quantitiesList[index] + "</td><td>"
					+ getUnit(productsList[index]) + "</td></tr>";
		}
		htmlProductsTable += "</table>";
	}

	private String getUnit(String productName) {
		String query = queryGetProductByName + productName + "'";
		Statement statement = null;
		ResultSet results = null;
		String unit = "";
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				unit = results.getString(tableProductsColumnUnit);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unit;
	}

	private void getCategory() {
		String query = queryGetCategoryByRecipeId + id + "'";
		int categoryId = 0;
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			if (results.next()) {
				categoryId = results.getInt(tableCategoriesMapColumnCategoryId);
			}
			
			results = statement.executeQuery(queryGetCategoryNameByID + categoryId + "'");
			if (results.next()) {
				this.category = results.getString(tableCategoriesColumnName);
			}
			generateHTMLProductsTable();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
