package com.vso.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.*;

public class Recipe implements DatabaseNames, TablesColumnNames {
	int id;
	String recipeName;
	String cookingDescription;
	String cookingTime;
	String difficulty;
	ArrayList<String> productsList = new ArrayList<>();
	ArrayList<String> quantitiesList = new ArrayList<>();
	String category;
	String portions;
	String htmlProductsTable;
	java.sql.Date publishingDate;
	Connection connectionDB = null;

	public Recipe(String recipeName) {
		getDbConnection();
		this.recipeName = recipeName;
		getRecipeFromDbByName(this.recipeName);
		setCategory();
	}

	public Recipe(int recipeId) {
		getDbConnection();
		this.id = recipeId;
		getRecipeFromDbById(this.id);
		setCategory();
//		printInfo();
	}

	private void printInfo() {
		System.out.println("Данни за рецептата:");
		System.out.println(id);
		System.out.println(recipeName);
		System.out.println(cookingDescription);
		System.out.println(cookingTime);
		System.out.println(difficulty);
		System.out.println(productsList.size());
		System.out.println(quantitiesList.size());
		System.out.println(category);
		System.out.println(portions);
		System.out.println(htmlProductsTable);
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

	public ArrayList<String> getProductsList() {
		return productsList;
	}

	public ArrayList<String> getQuantitiesList() {
		return quantitiesList;
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

	public String getHtmlProductsTable() {
		return htmlProductsTable;
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
				productsList.add(product.getProductName());
				quantitiesList.add(results.getString(tableProductsMapColumnQuantity));
			}
			generateHTMLProductsTable();
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
				recipeName = results.getString(tableRecipesColumnRecipeName);
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
				productsList.add(product.getProductName());
				quantitiesList.add(results.getString(tableProductsMapColumnQuantity));
			}
			generateHTMLProductsTable();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void generateHTMLProductsTable() {
		htmlProductsTable = "<table><tr><th>Продукт:</th><th>Количество</th><th>Мярка</th></tr>";
		for (int index = 0; index < productsList.size(); index++) {
			htmlProductsTable += "<tr><td>" + productsList.get(index) + "</td><td>" + quantitiesList.get(index) + "</td><td>"
					+ getUnit(productsList.get(index)) + "</td></tr>";
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

	private void setCategory() {
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
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getCategory() {
		return category;
	}
}