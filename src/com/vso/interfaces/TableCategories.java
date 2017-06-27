package com.vso.interfaces;

public interface TableCategories extends DatabaseNames {
	String tableCategoriesName = tableCategory;
	String tableCategoriesColumnId = "id";
	String tableCategoriesColumnName = "category_name";
	
	String createTableCategoriesCommand = "CREATE TABLE `" + databaseName + "`.`" + tableCategoriesName + "` ("
			+ tableCategoriesColumnId + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, " + tableCategoriesColumnName + " TEXT NOT NULL);";
	
	String tableCategoriesInsertCommand = "INSERT INTO `" + databaseName + "`.`" + tableCategoriesName + "` (`"
			+ tableCategoriesColumnName + "`) VALUES(";
	//FillTables.java
	
	String queryGetCategoryNameByID = "SELECT * FROM " + databaseName + "." + tableCategoriesName + " WHERE "
			+ tableCategoriesColumnId + "='";
	// String query = queryGetCategoryNameByID + categoryId + "'";
	
	String queryGetCategoryIDByName = "SELECT * FROM " + databaseName + "." + tableCategoriesName + " WHERE "
			+ tableCategoriesColumnName + "='";
	// String query = queryGetCategoryIDByName + categoryName + "'";
}
