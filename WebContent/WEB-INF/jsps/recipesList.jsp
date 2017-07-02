<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list.css">
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<title>List</title>
</head>
<body>
	<script type='text/javascript'>
		$(document).ready(function() {
			$('input[name=radio]').change(function() {
				$('form').submit();
			});
		});
	</script>
	<jsp:useBean id="list" class="com.javabeans.RecipesListGenerator" />
	<jsp:useBean id="names" class="com.javabeans.FormRecipeSearchNames" />
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
			if (pageId > 1) {
				startNumber = (pageId - 1) * showPerPage + 1;
			}
		} catch (Exception e) {
		}
		recipeIdsList = list.getListPartly(startNumber, showPerPage);
		recipeNamesList = list.getListRecpeNames();
		if (request.getAttribute(names.getFormSearchStartNumber()) != null) {
			startNumber = (Integer) request.getAttribute(names.getFormSearchStartNumber());
			showPerPage = (Integer) request.getAttribute(names.getFormSearchShowPerPage());
			columns = (Integer) request.getAttribute(names.getFormSearchColumnsNumber());
		}
	%>
	<div class="search_form">
		<form method="post" action="search">
			<div class="search_box">
				<input id="searchInput" name=<%=names.getFormSearchSearchString()%>
					class="form-control" placeholder="име на рецептата" type="search">
				<input class="red_button" type="submit" value="Търси">

				<div>
					<input type="hidden" name=<%=names.getFormSearchStartNumber()%>
						value=<%=startNumber%>> <input type="hidden"
						name=<%=names.getFormSearchShowPerPage()%> value=<%=showPerPage%>>
					<input type="hidden" name=<%=names.getFormSearchColumnsNumber()%>
						value=<%=columns%>>
				</div>
			</div>
		</form>
		<form method="post" action="show_category">
			<div id="div_radio">
				Покажи рецепти: <label class="radio-inline"> <input
					name="radio" type="radio" value="всички" checked="checked" />
					всички
				</label> <label class="radio-inline"> <input name="radio"
					type="radio" value="месни" /> месни
				</label><label class="radio-inline"> <input name="radio"
					type="radio" value="вегетариански" /> вегетариански
				</label> <label class="radio-inline"> <input name="radio"
					type="radio" value="веган" /> веган
				</label>
				<div>
					<input type="hidden" name=<%=names.getFormSearchStartNumber()%>
						value=<%=startNumber%>> <input type="hidden"
						name=<%=names.getFormSearchShowPerPage()%> value=<%=showPerPage%>>
					<input type="hidden" name=<%=names.getFormSearchColumnsNumber()%>
						value=<%=columns%>>
					<%-- 					<input type="hidden" name=<%= %> value=<%= %>> --%>
				</div>
			</div>
		</form>
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
			Страници:
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
				}
				if (allRecipes - startNumber < showPerPage) {
			%><br> (Показани
			<%=startNumber%>
			-
			<%=allRecipes%>
			от общо
			<%=allRecipes%>
			рецепти.)
			<%
				} else {
			%><br> (Показани
			<%=startNumber%>
			-
			<%=toNumber%>
			от общо
			<%=allRecipes%>
			рецепти.)
			<%
				}
			%>
		</p>
</body>
</html>