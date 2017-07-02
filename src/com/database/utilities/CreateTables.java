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
		try {
			dbStatement.executeUpdate(createTableProductsMapCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void crateCategoryTable() {
		try {
			dbStatement.executeUpdate(createTableCategoriesCommand);
		} catch (Exception e) {
		}
	}

	private void crateUserMap() {
		try {
			dbStatement.executeUpdate(createTableUsersMapCommand);
		} catch (Exception e) {
		}
	}

	private void crateCategoryMap() {
		try {
			dbStatement.executeUpdate(createTableCategoriesMapCommand);
		} catch (Exception e) {
		}
	}


	private void crateImagesTable() {
		try {
			dbStatement.executeUpdate(createTableImagesCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
