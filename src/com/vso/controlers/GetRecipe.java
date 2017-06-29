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
		String recipeId = request.getParameter("recipeId");
		Recipe recipe = new Recipe(recipeId);
		
		
		String productsList = "products";
		request.setAttribute(recipeName, recipe.getRecipeName());
		request.setAttribute(cookingDescription, recipe.getCookingDescription());
		request.setAttribute(cookingTime, recipe.getCookingTime());
		request.setAttribute(difficulty, recipe.getDifficulty());
		request.setAttribute(productsList, products);
		request.setAttribute(portions, recipe.getPortions());
		request.setAttribute(publishedDate, recipe.getPublishingDate());
		RequestDispatcher dispatcher = request.getRequestDispatcher("recipe");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
