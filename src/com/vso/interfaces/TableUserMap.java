package com.vso.interfaces;

public interface TableUserMap extends DatabaseNames, TableUsersNames, TableRecipesNames {
	String tableUserMapName = tableUserMap;
	String tableUserMapColumnId = "id";
	String tableUserMapColumnRecipeId = "recipe_id";
	String tableUserMapColumnUserId = "user_id";

	String createTableUsersMapCommand = "CREATE TABLE `" + databaseName + "`.`" + tableUserMapName + "` ("
			+ tableUserMapColumnId + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, " + tableUserMapColumnRecipeId
			+ " BIGINT UNSIGNED, " + tableUserMapColumnUserId + " BIGINT UNSIGNED, FOREIGN KEY ("
			+ tableUserMapColumnRecipeId + ") REFERENCES " + tableRecipesName + "(" + tableRecipesColumnID
			+ "), FOREIGN KEY (" + tableUserMapColumnUserId + ") REFERENCES " + tableUsers + "(" + tableUsersColumnId
			+ "));";

	String queryNewUsersMapRecord = "INSERT INTO `" + databaseName + "`.`" + tableUserMapName + "` (`"
			+ tableUserMapColumnRecipeId + "`, `" + tableUserMapColumnUserId + "`) VALUES (?,?);";
	// 1 - recipeId; 2 - userId

	String queryGetRecipeIdByUserId = "SELECT * FROM " + databaseName + "." + tableUserMapName + " WHERE "
			+ tableUserMapColumnUserId + "='";
	// String query = queryGetRecipeIdByUserId + userId + "'";
	
	String queryCountRowsByUserId = "SELECT COUNT(*) AS count FROM " + databaseName + "." + tableUserMapName + " WHERE "
			+ tableUserMapColumnUserId + "='";
	// String query = queryCountRowsByUserId + userId + "'";
}
