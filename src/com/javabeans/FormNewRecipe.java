package com.javabeans;

import java.io.Serializable;

import com.vso.interfaces.FormNamesNewRecipe;

public class FormNewRecipe implements Serializable, FormNamesNewRecipe {
	private static final long serialVersionUID = 1L;

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
	
	public String getImageInputName() {
		return imageInputName;
	}
	
	public String getQuantityInputName() {
		return quantityInputName;
	}
}