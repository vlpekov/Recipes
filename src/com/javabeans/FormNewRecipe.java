package com.javabeans;

import com.vso.interfaces.FormNamesNewRecipe;

public class FormNewRecipe implements FormNamesNewRecipe {

	public String getRecipeTitleInputName() {
		return recipeTitleInputName;
	}

	public String getCookingDescriptionInputName() {
		return cookingDescriptionInputName;
	}

	public String getProductsInputName() {
		return productsInputName;
	}

	public String getTimeInputName() {
		return timeInputName;
	}

	public String getDifficultyInputName() {
		return difficultyInputName;
	}

	public String getPortionsInputName() {
		return portionsInputName;
	}
}