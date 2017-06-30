<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/recipe_view.css">
<title>Преглед на рецепта</title>
</head>
<body>
	<jsp:useBean id="tags" class="com.javabeans.RecipeTagsNames" />
	<div class="container">
		<div class="site_label">
			<a href="/Recipes/" target="_top"> <img border="0"
				alt="Рецептурник" src="img/label.png" height="150">
			</a>
		</div>
		<div class="username">
			<h1><%=request.getAttribute(tags.getRecipeName())%></h1>
			<img class="hr_img" border="0" src="img/hr.png">
		</div>
		<table>
			<tr>
				<td><a
					href="recipeImg?recipeId=<%=request.getAttribute(tags.getIdRecipe())%>"><img
						src="recipeImg?recipeId=<%=request.getAttribute(tags.getIdRecipe())%>"
						class="square_pic" width="200" height="200"></a></td>
				<td class="inner_table"><h3><%=request.getAttribute(tags.getProductsList())%></h3>
				<td>
		</table>
		<div class="text">
			<h5><%=request.getAttribute(tags.getCookingDescription())%></h5>
		</div>
		<div>
			<img border="0" src="img/hr2top.png" class="hr_img_bottom">
			<h3>
				<table>
					<tr class="info">
						<td width="50%">Време за приготвяне: <img src="img/time.png"
							alt="Време за приготвяне:" class="icons"> <%=request.getAttribute(tags.getCookingTime())%>ч.
						</td>
						<td><img src="img/separator.png" class="icons"></td>
						<td width="50%">Брой порции: <img src="img/food.png"
							alt="Брой порции" class="icons"> <%=request.getAttribute(tags.getPortions())%>
						</td>
					</tr>
				</table>
			</h3>
			<img border="0" src="img/hr2.png"> </a>
		</div>
		<div class="right">
			<h4>
				Трудност: <img
					src="img/diff<%=request.getAttribute(tags.getDifficulty())%>.png"
					class="icons">
			</h4>
		</div>
	</div>
</body>
</html>