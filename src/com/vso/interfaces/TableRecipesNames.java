package com.vso.interfaces;

public interface TableRecipesNames extends DatabaseNames {
	String tableRecipesName = tableRecipes;
	String tableRecipesColumnID = "id";
	String tableRecipesColumnRecipeName = "name";
	String tableRecipesColumnRecipeDescription = "description";
	String tableRecipesPublishingDate = "published_date";
	String tableRecipesColumnImageFile = "img_file";
	String tableRecipesColumnImageName = "picture_name";

	String createTableUsersCommand = "CREATE TABLE `" + databaseName + "`.`" + tableRecipesName + "` ("
			+ tableRecipesColumnID + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, " + tableRecipesColumnRecipeName
			+ " TEXT NOT NULL UNIQUE, " + tableRecipesColumnRecipeDescription + " TEXT NOT NULL, "
			+ tableRecipesPublishingDate + " DATE NOT NULL, " + tableRecipesColumnImageFile + " MEDIUMBLOB NOT NULL, "
			+ tableRecipesColumnImageName + " TEXT NOT NULL);";

}
