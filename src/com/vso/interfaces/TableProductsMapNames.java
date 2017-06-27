package com.vso.interfaces;

public interface TableProductsMapNames extends DatabaseNames, TableProductsNames, TableRecipesNames {
	String tableProductsMapName = tableProductsMap;
	String tableProductsMapColumnId = "id";
	String tableProductsMapColumnProductId = "product_id";
	String tableProductsMapColumnRecipeId = "recipe_id";
	String tableProductsMapColumnQuantity = "quantity";

	String createTableProductsMapCommand = "CREATE TABLE `" + databaseName + "`.`" + tableProductsMapName + "` ("
			+ tableProductsMapColumnId + " SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT, "
			+ tableProductsMapColumnProductId + " BIGINT UNSIGNED, " + tableProductsMapColumnRecipeId
			+ " BIGINT UNSIGNED, FOREIGN KEY (" + tableProductsMapColumnProductId + ") REFERENCES " + tableProductsName
			+ "(" + tableProductsColumnId + "), FOREIGN KEY (" + tableProductsMapColumnRecipeId + ") REFERENCES "
			+ tableRecipesName + "(" + tableRecipesColumnID + "), " + tableProductsMapColumnQuantity
			+ " INT NOT NULL);";

	String queryNewProductsMapRecord = "INSERT INTO `" + databaseName + "`.`" + tableProductsMapName + "` (`"
			+ tableProductsMapColumnProductId + "`, `" + tableProductsMapColumnRecipeId + "`, `"
			+ tableProductsMapColumnQuantity + "`) VALUES (?,?,?);";
	// 1 - ProductId; 2 - RecipeId; 3 - Quantity;
}
