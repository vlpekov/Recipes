<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list_user.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="list" class="com.javabeans.UserRecipesList" />
	<%!ArrayList<String> recipeIdsList = new ArrayList<String>();
	ArrayList<String> recipeNamesList = new ArrayList<String>();%>
	<%
		int showPerPage = 3;
		int startNumber = 1;
		int columns = 3;
		String username = request.getParameter("username");
		try {
			int pageId = Integer.parseInt(request.getParameter("page"));
			if (pageId > 1) {
				startNumber = (pageId - 1) * showPerPage + 1;
			}
		} catch (Exception e) {
		}
		recipeIdsList = list.getUserRecipesListPartly(startNumber, showPerPage, username);
		recipeNamesList = list.getListRecpeNames();
	%>
	<table>
		<tr>
			<%
				for (int index = 0; index < recipeIdsList.size(); index++) {
			%><td><div class="image">
					<a href="getRecipe?recipeId=<%=recipeIdsList.get(index)%>"
						target="_parent"><img
						src="recipeImg?recipeId=<%=recipeIdsList.get(index)%>"
						class="square_pic" width="200" height="200"></a>
					<h2>
						<span><%=recipeNamesList.get(index)%></span>
					</h2>
				</div></td>
			<%
				if ((index > 0) && ((index + 1) % columns == 0)) {
						out.print("</tr><tr>");
					}
				}
			%>
		</tr>
	</table>
	<%
		int toNumber = startNumber + showPerPage - 1;
		int allRecipes = list.getRowsNumber(username);
		int pages = allRecipes / showPerPage + 1;
		int pageId;
		try {
			pageId = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			pageId = 1;
		}
	%>
	<%
	if (allRecipes == 0) { out.println("<h4>Няма публикувани рецепти</h4>"); } else {%>
	<h4>
		<%
			for (int currentPage = 1; currentPage <= pages; currentPage++) {
				if (pageId == currentPage) {
		out.print(currentPage);
			} else {
		%>
		<a href="user_recipes?username=<%=username%>&page=<%=currentPage%>"><%=currentPage%></a>
		<%
			}
			}
			if (allRecipes - startNumber < showPerPage) {
		%>
		Показани
		<%=startNumber%>
		-
		<%=allRecipes%>
		от общо
		<%=allRecipes%>
		рецепти.
		<%
			} else {
		%>
		Показани
		<%=startNumber%>
		-
		<%=toNumber%>
		от общо
		<%=allRecipes%>
		рецепти.
		<%
			}
		%>
	</h4>
	<%} %>
</body>
</html>