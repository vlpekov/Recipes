<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/newInput.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/newRecipe.css">
<title>Нова рецепта</title>
</head>
<body>
	<div class="form-container">
		<div class="form-box">
			<h2>Нова рецепта:</h2>

			<form action="saveRecipe" id="mainform" method="post" name="recipe_data">
				Име на рецептата:<input class="form-field" type="text"
					name="recipe_name" placeholder="Име">
				<div>
					Начин на приготвяне:
					<textarea class="form-field_description" id="description"
						name="description"></textarea>
				</div>

				Продукти:
				<table id="products_table">
					<tr>
						<td><input type="text" placeholder="Продукт"
							class="form-field_product" name="product_0"></td>
						<td><input type="text" placeholder="Количество"
							class="form-field_quantity" name="quantity_0"></td>
						<td></td>
					</tr>
				</table>
				<button type="button" class="white_button" onclick="newRow('products_table')">Нов
					продукт</button>
				<input class="brown_button" type="submit" value="Публикувай рецептата">
			</form>

		</div>
	</div>

</body>
</html>