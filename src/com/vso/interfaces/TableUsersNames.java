package com.vso.interfaces;

public interface TableUsersNames extends DatabaseNames {
	String tableUsersName = tableUsers;
	String tableUsersColumnId = "id";
	String tableUsersColumnUsername = "username";
	String tableUsersColumnPassword = "password";
	String tableUsersColumnFirstName = "first_name";
	String tableUsersColumnLastName = "last_name";
	String tableUsersColumnEmail = "email";
	String tableUsersColumnRegistrationDate = "date_of_registration";
	String tableUsersColumnGender = "gender";
	String tableUsersColumnProfilPictureFile = "image";
	String tableUsersColumnProfilPictureName = "image_name";

	String createTableUsersCommand = "CREATE TABLE `" + databaseName + "`.`" + tableUsersName + "` ("
			+ tableUsersColumnId + " SERIAL PRIMARY KEY NOT NULL, " + tableUsersColumnUsername + " TEXT NOT NULL, "
			+ tableUsersColumnPassword + " TEXT NOT NULL, " + tableUsersColumnFirstName + " TEXT NOT NULL, "
			+ tableUsersColumnLastName + " TEXT NOT NULL, " + tableUsersColumnEmail + " TEXT NOT NULL, "
			+ tableUsersColumnRegistrationDate + " DATE NOT NULL, " + tableUsersColumnGender + " TEXT NOT NULL, "
			+ tableUsersColumnProfilPictureFile + " MEDIUMBLOB NOT NULL, " + tableUsersColumnProfilPictureName
			+ " TEXT NOT NULL, UNIQUE (" + tableUsersColumnUsername + "(20)));";

	String queryAddNewUser = "INSERT INTO `" + databaseName + "`.`" + tableUsersName + "` (`" + tableUsersColumnUsername
			+ "`, `" + tableUsersColumnPassword + "`, `" + tableUsersColumnFirstName + "`, `" + tableUsersColumnLastName
			+ "`, `" + tableUsersColumnEmail + "`, `" + tableUsersColumnRegistrationDate + "`, `"
			+ tableUsersColumnGender + "`, `" + tableUsersColumnProfilPictureFile + "`, `"
			+ tableUsersColumnProfilPictureName + "`) VALUES (?,?,?,?,?,?,?,?,?);";

	String queryGetUserByUsername = "SELECT * FROM " + databaseName + "." + tableUsersName + " WHERE "
			+ tableUsersColumnUsername + "='";
	// String query = queryGetUserByUsername + username + "'";

	String queryGetUserById = "SELECT * FROM " + databaseName + "." + tableUsersName + " WHERE " + tableUsersColumnId
			+ "='";
	// String query = queryGetUserById + userId+ "'";
}
