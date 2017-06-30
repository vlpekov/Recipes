<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="list" class="com.javabeans.RecipesListGenerator" />
	<%!ArrayList<String> recipeIdsList = new ArrayList<String>();
	ArrayList<String> recipeNamesList = new ArrayList<String>();%>
	<%
		int showPerPage = 12;
		int startNumber = 1;
		int columns = 4;
		try {
			columns = Integer.parseInt(request.getParameter("iframeColumns"));
		} catch (Exception e) {
		}
		try {
			int pageId = Integer.parseInt(request.getParameter("page"));
			System.out.println("startNumber: " + startNumber + "; pageId:" + pageId
					+ "**************************************************");
			if (pageId > 1) {
				startNumber = (pageId - 1) * showPerPage + 1;
			}
			System.out.println("startNumber: " + startNumber + "; pageId:" + pageId
					+ "**************************************************");
		} catch (Exception e) {
		}
		recipeIdsList = list.getListPartly(startNumber, showPerPage);
		recipeNamesList = list.getListRecpeNames();
	%>

	Покажи най-новите рецепти
	<table>
		<tr>
			<%
				System.out.println(recipeIdsList.size());
				for (int index = 0; index < recipeIdsList.size(); index++) {
					System.out.println(columns);
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
			%>
		</tr>
		<tr>
			<%
				}
				}
			%>
		</tr>
	</table>
	<%
		int toNumber = startNumber + showPerPage - 1;
		int allRecipes = list.getRowsNumber();
		int pages = allRecipes / showPerPage + 1;
		int pageId;
		try {
			pageId = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			pageId = 1;
		}
	%>
	<p>
		<%
			for (int currentPage = 1; currentPage <= pages; currentPage++) {
				if (pageId == currentPage) {
		%>
		<%=currentPage%>
		<%
			} else {
		%>
		<a href="list?iframeColumns=<%=columns%>&page=<%=currentPage%>"><%=currentPage%></a>
		<%
			}
		%>
		<%
			}
		%>
		<%
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
		от общо рецепти.
		<%
			}
		%>
	</p>
</body>
</html>