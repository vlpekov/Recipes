package com.vso.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.database.utilities.ConnectorDB;
import com.vso.interfaces.TableProductsNames;

public class Product implements TableProductsNames {
	private int productId;
	private String productName;
	private String productCategory;
	private String productCalories;
	private String productFats;
	private String productProteins;
	private String productCarbohydrates;
	private String productUnit;
	private String productGroup;
	Connection connectionDB = null;

	public Product(int productId) {
		this.productId = productId;
		getDbConnection();
		getProductFromDbById(productId);
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

	public void getProductFromDbById(int id) {
		String query = queryGetProductById + id + "'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connectionDB.createStatement();
			results = statement.executeQuery(query);
			results = statement.executeQuery(query);
			if (results.next()) {
				productName = results.getString(tableProductsColumnName);
				productCategory = results.getString(tableProductsColumnCategory);
				productCalories = results.getString(tableProductsColumnCalories);
				productFats = results.getString(tableProductsColumnFats);
				productProteins = results.getString(tableProductsColumnProteins);
				productCarbohydrates = results.getString(tableProductsColumnCarbohydrates);
				productUnit = results.getString(tableProductsColumnUnit);
				productGroup = results.getString(tableProductsColumnGroup);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public String getProductCalories() {
		return productCalories;
	}

	public String getProductFats() {
		return productFats;
	}

	public String getProductProteins() {
		return productProteins;
	}

	public String getProductCarbohydrates() {
		return productCarbohydrates;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public Connection getConnectionDB() {
		return connectionDB;
	}
	
	
}
