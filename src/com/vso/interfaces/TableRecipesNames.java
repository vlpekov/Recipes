package com.vso.interfaces;

import java.sql.ResultSet;
import java.sql.Statement;

import com.database.utilities.ConnectorDB;

public interface TableRecipesNames extends DatabaseNames {
	String tableRecipesName = tableRecipes;
	String tableRecipesColumnID = "id";
	String tableRecipesColumnRecipeName = "name";
	String tableRecipesColumnRecipeDescription = "description";
	String tableRecipesColumnPublishingDate = "published_date";
	String tableRecipesColumnCookingTime = "cooking_time";
	String tableRecipesColumnDifficulty = "difficulty";
	String tableRecipesColumnPortions = "portion";

	String createTableRecipesCommand = "CREATE TABLE `" + databaseName + "`.`" + tableRecipesName + "` ("
			+ tableRecipesColumnID + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, " + tableRecipesColumnRecipeName
			+ " TEXT NOT NULL, " + tableRecipesColumnRecipeDescription + " TEXT NOT NULL, "
			+ tableRecipesColumnPublishingDate + " DATE NOT NULL, " + tableRecipesColumnCookingTime + " TEXT NOT NULL, "
			+ tableRecipesColumnDifficulty + " INT NOT NULL, " + tableRecipesColumnPortions + " INT NOT NULL);";

	String queryGetRecipeByName = "SELECT * FROM " + databaseName + "." + tableRecipesName + " where "
			+ tableRecipesColumnRecipeName + "='";
	// String query = queryGetRecipeByName + recipeName + "'";

	String queryGetRecipeById = "SELECT * FROM " + databaseName + "." + tableRecipesName + " where "
			+ tableRecipesColumnID + "='";
	// String query = queryGetRecipeById + recipeId + "'";
	
	String queryGetFullList = "SELECT * FROM " + databaseName + "." + tableRecipesName;
	// String query = queryGetRecipeById + recipeId + "'";

	String queryNewRecipeRecord = "INSERT INTO `" + databaseName + "`.`" + tableRecipesName + "` (`"
			+ tableRecipesColumnRecipeName + "`, `" + tableRecipesColumnRecipeDescription + "`, `"
			+ tableRecipesColumnPublishingDate + "`, `" + tableRecipesColumnCookingTime + "`,`"
			+ tableRecipesColumnDifficulty + "`, `" + tableRecipesColumnPortions + "`) VALUES (?,?,?,?,?,?);";
	// 1 - RecipeName; 2 - RecipeDescription; 3 - PublishingDate; 4 - CookingTime; 5 - Difficulty; 6 - Portions;
}