package com.database.utilities;

import java.sql.Connection;
import java.sql.Statement;

import com.vso.interfaces.*;

public class CreateTables implements DatabaseNames, TablesColumnNames {
	private String dbName = SetupDB.getDbName();
	SetupDB single = SetupDB.getInstance();
	private Statement dbStatement = SetupDB.getStatement();

	public CreateTables() {
		crateUsersTable();
		crateRecipesTable();
		crateCategoryTable();
		crateProductsTable();
		crateUserMap();
		crateCategoryMap();
		crateProductsMapTable();
		crateImagesTable();
	}

	private void crateUsersTable() {
		try {
			dbStatement.executeUpdate(createTableUsersCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void crateRecipesTable() {
		try {
			dbStatement.executeUpdate(createTableRecipesCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void crateProductsTable() {
		try {
			dbStatement.executeUpdate(createTableProductsCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void crateProductsMapTable() {
		System.out.println(createTableProductsMapCommand);
		try {
			dbStatement.executeUpdate(createTableProductsMapCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void crateCategoryTable() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`category` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "name TEXT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
		}
	}

	private void crateUserMap() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`user_map` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "user_id INT NOT NULL, " + "recipe_id INT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
		}
	}

	private void crateCategoryMap() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`category_map` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "category_id INT NOT NULL, " + "recipe_id INT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
		}
	}


	private void crateImagesTable() {
		String crateTable = "CREATE TABLE `" + dbName + "`.`images` (" + "id SERIAL PRIMARY KEY NOT NULL, "
				+ "image MEDIUMBLOB NOT NULL);";

		try {
			dbStatement.executeUpdate(crateTable);
			System.out.println(crateTable);
		} catch (Exception e) {
			System.out.println("Ops... crateUsersTable failed");
			e.printStackTrace();
		}
	}
}
