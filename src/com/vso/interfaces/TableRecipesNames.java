package com.vso.interfaces;

public interface TableRecipesNames extends DatabaseNames {
	String tableRecipesName = tableRecipes;
	String tableRecipesColumnID = "id";
	String tableRecipesColumnRecipeName = "name";
	String tableRecipesColumnRecipeDescription = "description";
	String tableRecipesColumnPublishingDate = "published_date";
	String tableRecipesColumnCookingTime = "picture_name";
	String tableRecipesColumnDifficulty = "difficulty";
	String tableRecipesColumnPortions = "portion";
	
	String createTableRecipesCommand = "CREATE TABLE `" + databaseName + "`.`" + tableRecipesName + "` ("
			+ tableRecipesColumnID + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, " + tableRecipesColumnRecipeName
			+ " TEXT NOT NULL, " + tableRecipesColumnRecipeDescription + " TEXT NOT NULL, "
			+ tableRecipesColumnPublishingDate + " DATE NOT NULL, " + tableRecipesColumnCookingTime + " TEXT NOT NULL, " + tableRecipesColumnDifficulty + " INT NOT NULL, " + tableRecipesColumnPortions + " INT NOT NULL);";

}
