package com.database.utilities;

import java.sql.Connection;
import java.sql.Statement;

import com.vso.interfaces.DatabaseNames;

public class CreateTables implements DatabaseNames {
	private static String dbName = SetupDB.getDbName();
	SetupDB single = SetupDB.getInstance();
	private static Statement dbStatement = SetupDB.getStatement();

	public static void CreateAllTables() {
		crateUsersTable();
		crateRecipesTable();
		crateCategoryTable();
		crateProductsTable();
		crateUserMap();
		crateCategoryMap();
		crateProductsMap();
		crateImagesTable();
	}

	public static void crateUsersTable() {
		String crateTable = "CREATE TABLE `" + dbName + "`.`users` (" + "id SERIAL PRIMARY KEY NOT NULL, "
				+ "username TEXT NOT NULL, " + "password TEXT NOT NULL, " + "first_name TEXT NOT NULL, "
				+ "last_name TEXT NOT NULL, " + "email TEXT NOT NULL, " + "date_of_registration DATE NOT NULL, "
				+ "gender TEXT NOT NULL, is_remember INT NOT NULL," + "image MEDIUMBLOB NOT NULL, "
				+ "image_name TEXT NOT NULL);";

		try {
			dbStatement.executeUpdate(crateTable);
			System.out.println(crateTable);
		} catch (Exception e) {
			System.out.println("Ops... crateUsersTable failed");
			e.printStackTrace();
		}
	}

	public static void crateRecipesTable() {
		String crateTable = "CREATE TABLE `" + dbName + "`.`recipes` (" + "id SERIAL PRIMARY KEY NOT NULL, "
				+ "name TEXT NOT NULL, " + "cooking_description TEXT NOT NULL, " + "type_idmap INT NOT NULL, "
				+ "user_idmap INT NOT NULL, " + "products_idmap INT NOT NULL);";

		try {
			System.out.println(crateTable);
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void crateProductsTable() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`products` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "name TEXT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void crateCategoryTable() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`category` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "name TEXT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
		}
	}

	public static void crateUserMap() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`user_map` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "user_id INT NOT NULL, " + "recipe_id INT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
		}
	}

	public static void crateCategoryMap() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`category_map` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "category_id INT NOT NULL, " + "recipe_id INT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
		}
	}

	public static void crateProductsMap() {
		try {
			String crateTable = "CREATE TABLE `" + dbName + "`.`products_map` (" + "id SERIAL PRIMARY KEY NOT NULL, "
					+ "products_id INT NOT NULL, " + "recipe_id INT NOT NULL);";
			dbStatement.executeUpdate(crateTable);
		} catch (Exception e) {
		}
	}

	public static void crateImagesTable() {
		String crateTable = "CREATE TABLE `" + dbName + "`.`images` (" + "id SERIAL PRIMARY KEY NOT NULL, "
				+  "image MEDIUMBLOB NOT NULL);";

		try {
			dbStatement.executeUpdate(crateTable);
			System.out.println(crateTable);
		} catch (Exception e) {
			System.out.println("Ops... crateUsersTable failed");
			e.printStackTrace();
		}
	}
}
