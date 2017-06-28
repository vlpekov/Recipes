package com.vso.interfaces;

public interface TableImages extends DatabaseNames, TableRecipesNames {
	String tableImagesName = tableImages;
	String tableImagesColumnId = "id";
	String tableImagesColumnImageFile = "image_file";
	String tableImagesColumnImageName = "image_name";
	String tableImagesColumnRecipeId = "recipe_id";

	String createTableImagesCommand = "CREATE TABLE `" + databaseName + "`.`" + tableImagesName + "` ("
			+ tableImagesColumnId + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, " + tableImagesColumnImageFile
			+ " MEDIUMBLOB NOT NULL, " + tableImagesColumnImageName + " TEXT NOT NULL, " + tableImagesColumnRecipeId
			+ " BIGINT UNSIGNED, FOREIGN KEY (" + tableImagesColumnRecipeId + ") REFERENCES " + tableRecipesName + "("
			+ tableRecipesColumnID + "));";

	String queryNewImageRecord = "INSERT INTO `" + databaseName + "`.`" + tableImagesName + "` (`"
			+ tableImagesColumnImageFile + "`, `" + tableImagesColumnImageName + "`, `" + tableImagesColumnRecipeId
			+ "`) VALUES (?,?,?);";
	// 1 - ImageFile; 2 - ImageName; 3 - recipeId;
}
