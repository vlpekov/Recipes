package com.vso.interfaces;

public interface TableProductsNames extends DatabaseNames {
	String tableProductsName = tableProducts;
	String tableProductsColumnId = "id";
	String tableProductsColumnName = "name";
	String tableProductsColumnCategory = "category";
	String tableProductsColumnCalories = "calories";
	String tableProductsColumnFats = "fats";
	String tableProductsColumnProteins = "proteins";
	String tableProductsColumnCarbohydrates = "carbohydrates";
	String tableProductsColumnUnit = "unit";
	String tableProductsColumnGroup = "type";
	String createTableProductsCommand = "CREATE TABLE `" + databaseName + "`.`" + tableProductsName + "` ("
			+ tableProductsColumnId + " SERIAL PRIMARY KEY NOT NULL, " + tableProductsColumnName + " TEXT NOT NULL, "
			+ tableProductsColumnCategory + " TEXT NOT NULL, " + tableProductsColumnCalories + " TEXT NOT NULL, "
			+ tableProductsColumnFats + " TEXT NOT NULL, " + tableProductsColumnProteins + " TEXT NOT NULL, "
			+ tableProductsColumnCarbohydrates + " TEXT NOT NULL, " + tableProductsColumnUnit + " TEXT NOT NULL, "
			+ tableProductsColumnGroup + " TEXT NOT NULL);";
	
	String tableProductsInsertCommand = "INSERT INTO `" + databaseName + "`.`" + tableProductsName + "` (`"
			+ tableProductsColumnName + "`, `" + tableProductsColumnCategory + "`, `" + tableProductsColumnCalories
			+ "`, `" + tableProductsColumnFats + "`, `" + tableProductsColumnProteins + "`, `"
			+ tableProductsColumnCarbohydrates + "`, `" + tableProductsColumnUnit + "`, `" + tableProductsColumnGroup
			+ "`) VALUES(";
	//FillTables.java
	
	String queryGetProductByName = "SELECT * FROM " + databaseName + "." + tableProductsName + " WHERE "
			+ tableProductsColumnName + "='";
	// String query = queryGetProductByName + productName + "'";
	
	String queryGetProductById = "SELECT * FROM " + databaseName + "." + tableProductsName + " WHERE "
			+ tableProductsColumnId + "='";
	// String query = queryGetProductCategoryByName + productName + "'";
}
