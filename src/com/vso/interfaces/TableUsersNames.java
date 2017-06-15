package com.vso.interfaces;

public interface TableUsersNames extends DatabaseNames {
	String tableUsersName = "users";
	String tableUsersId = "id";
	String tableUsersUsername = "username";
	String tableUsersPassword = "password";
	String tableUsersFirstName = "first_name";
	String tableUsersLastName = "last_name";
	String tableUsersEmail = "email";
	String tableUsersRegistrationDate = "date_of_registration";
	String tableUsersGender = "gender";
	String tableUsersProfilPictureFile = "image";
	String tableUsersProfilPictureName = "image_name";

	String crateTableComand = "CREATE TABLE `" + databaseName + "`.`" + tableUsersName + "` (" + tableUsersId
			+ " SERIAL PRIMARY KEY NOT NULL, " + tableUsersUsername + " TEXT NOT NULL, " + tableUsersPassword
			+ " TEXT NOT NULL, " + tableUsersFirstName + " TEXT NOT NULL, " + tableUsersLastName + " TEXT NOT NULL, "
			+ tableUsersEmail + " TEXT NOT NULL, " + tableUsersRegistrationDate + " DATE NOT NULL, " + tableUsersGender
			+ " TEXT NOT NULL," + tableUsersProfilPictureFile + " MEDIUMBLOB NOT NULL, " + tableUsersProfilPictureName
			+ " TEXT NOT NULL);";
}
