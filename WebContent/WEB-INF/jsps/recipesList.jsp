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
		int showPerPage = 9;
		int startNumber = 1;
		int columns = 4;
		try {
			columns = Integer.parseInt(request.getParameter("iframeColumns"));
			int pageId = Integer.parseInt(request.getParameter("page"));
			if (pageId > 1) {
				startNumber = (pageId - 1) * showPerPage + 1;
			}
		} catch (Exception e) {
		}
		recipeIdsList = list.getListPartly(startNumber, showPerPage);
		recipeNamesList = list.getListRecpeNames();
	%>

	Резултати рецепти:
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
</body>
</html>