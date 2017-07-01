package com.vso.interfaces;

public interface TableCategoriesMapNames extends DatabaseNames, TableCategories, TableRecipesNames {
	String tableCategoriesMapName = tableCategoriesMap;
	String tableCategoriesMapColumnId = "id";
	String tableCategoriesMapColumnRecipeId = "recipe_id";
	String tableCategoriesMapColumnCategoryId = "category_id";
	
	String createTableCategoriesMapCommand = "CREATE TABLE `" + databaseName + "`.`" + tableCategoriesMapName + "` ("
			+ tableCategoriesMapColumnId + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, "
			+ tableCategoriesMapColumnRecipeId + " BIGINT UNSIGNED, " + tableCategoriesMapColumnCategoryId
			+ " BIGINT UNSIGNED, FOREIGN KEY (" + tableCategoriesMapColumnRecipeId + ") REFERENCES "
					+ tableRecipesName + "(" + tableRecipesColumnID + "), FOREIGN KEY (" + tableCategoriesMapColumnCategoryId + ") REFERENCES "
			+ tableCategories + "(" + tableCategoriesColumnId + "));";
	
	String queryNewCategoriesMapRecord = "INSERT INTO `" + databaseName + "`.`" + tableCategoriesMapName + "` (`"
			+ tableCategoriesMapColumnRecipeId + "`, `" + tableCategoriesMapColumnCategoryId + "`) VALUES (?,?);";
	// 1 - recipeId; 2 - categoryId
	
	String queryGetCategoryByRecipeId = "SELECT * FROM " + databaseName + "." + tableCategoriesMapName + " WHERE "
			+ tableCategoriesMapColumnRecipeId + "='";
	// String query = queryGetCategoryByRecipeId + id + "'";
	
	String queryGetCategoryByCategory = "SELECT * FROM " + databaseName + "." + tableCategoriesMapName + " WHERE "
			+ tableCategoriesMapColumnCategoryId + "='";
	// String query = queryGetCategoryByCategory + id + "'";
}

