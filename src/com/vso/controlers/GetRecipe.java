package com.vso.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vso.interfaces.RecipeTags;
import com.vso.models.Recipe;

/**
 * Servlet implementation class GetRecipe
 */
@WebServlet("/GetRecipe")
public class GetRecipe extends HttpServlet implements RecipeTags{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecipe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recipeId = Integer.parseInt(request.getParameter("recipeId"));
		Recipe recipe = new Recipe(recipeId);
		request.setAttribute(idRecipe, recipeId);
		request.setAttribute(recipeName, recipe.getRecipeName());
		request.setAttribute(cookingDescription, recipe.getCookingDescription());
		request.setAttribute(cookingTime, recipe.getCookingTime());
		request.setAttribute(difficulty, recipe.getDifficulty());
		request.setAttribute(productsList, recipe.getHtmlProductsTable());
		request.setAttribute(portions, recipe.getPortions());
		request.setAttribute(publishedDate, recipe.getPublishingDate());
		request.setAttribute(category, recipe.getCategory());
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_recipe");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
