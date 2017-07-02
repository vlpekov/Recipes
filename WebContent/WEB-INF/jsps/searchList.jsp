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
<title>Recipes</title>
</head>
<script>
	function show_form(a) {
		if (a == 1)
			document.getElementById("search_form").style.display = "none";
		else
			document.getElementById("search_form").style.display = "block";
	}
</script>

<body>
	<jsp:useBean id="names" class="com.javabeans.FormRecipeSearchNames" />
	<%!ArrayList<String> recipeIdsList = new ArrayList<String>();
	ArrayList<String> recipeNamesList = new ArrayList<String>();%>
	<%
		int startNumber = (Integer) request.getAttribute(names.getFormSearchStartNumber());
		int showPerPage = (Integer) request.getAttribute(names.getFormSearchShowPerPage());
		int columns = (Integer) request.getAttribute(names.getFormSearchColumnsNumber());
		recipeIdsList = (ArrayList<String>) request.getAttribute("ids");
		recipeNamesList = (ArrayList<String>) request.getAttribute("names");
		int allRecipes = (Integer) request.getAttribute(names.getFormSearchRecpeAllRecipesNumber());
		String searchFor = (String) request.getAttribute(names.getFormSearchSearchString());
		String allChecked = "checked=\"checked\"";
		String vegetarianChecked = "";
		String veganChecked = "";
		String meatyChecked = "";
		allChecked = (String) request.getAttribute(names.getFormSearchRadioCheckedAll());
		vegetarianChecked = (String) request.getAttribute(names.getFormSearchRadioCheckedVegetarian());
		veganChecked = (String) request.getAttribute(names.getFormSearchRadioCheckedVegan());
		meatyChecked = (String) request.getAttribute(names.getFormSearchRadioCheckedMeaty());
	%>
	<script type='text/javascript'>
		$(document).ready(function() {
			$('input[name=radio]').change(function() {
				$('form').submit();
			});
		});
	</script>
	<div class="search_form">
		<form method="post" action="search" id="parametеrs">

			<div class="search_box">
				<input id="searchInput" name=<%=names.getFormSearchSearchString()%>
					class="form-control" placeholder="име на рецептата" type="search">
				<input class="red_button" type="submit" value="Търси">
			</div>
			<div>
				<input type="hidden" name=<%=names.getFormSearchStartNumber()%>
					value=<%=startNumber%>> <input type="hidden"
					name=<%=names.getFormSearchShowPerPage()%> value=<%=showPerPage%>>
				<input type="hidden" name=<%=names.getFormSearchColumnsNumber()%>
					value=<%=columns%>>
			</div>
		</form>
	</div>
	<form method="post" action="show_category">
		<div id="div_radio">
			Покажи рецепти: <label class="radio-inline"> <input
				name="radio" type="radio" value="всички" <%=allChecked%> /> всички
			</label> <label class="radio-inline"> <input name="radio"
				type="radio" value="месни" <%=meatyChecked%> /> месни
			</label> <label class="radio-inline"> <input name="radio"
				type="radio" value="вегетариански" <%=vegetarianChecked%> />
				вегетариански
			</label> <label class="radio-inline"> <input name="radio"
				type="radio" value="веган" <%=veganChecked%> /> веган
			</label>
		</div>
		<input type="hidden" name=<%=names.getFormSearchStartNumber()%>
			value=<%=startNumber%>> <input type="hidden"
			name=<%=names.getFormSearchShowPerPage()%> value=<%=showPerPage%>>
		<input type="hidden" name=<%=names.getFormSearchColumnsNumber()%>
			value=<%=columns%>>
		</div>
		</div>
	</form>
	<%
		if (searchFor != null && recipeIdsList.size() > 0) {
	%>
	<p>
		Показани за резултати за търсенен на "<%=searchFor%>":
	</p>
	<%
		} else if (recipeIdsList.size() < 1) {
	%>
	<p>Няма намерени резултати!</p>
	<%
		}
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
	</p>
</body>
</html>