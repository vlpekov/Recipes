<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Нова рецепта</title>
<script src="js/newInput.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/newRecipe.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.11.2.js"></script>
<script src="js/jquery-ui.js"></script>

</head>
<body>
	<script>
		previousValue = "";
		$(function() {
			$("input[name='product']")
					.keypress(
							function() {
								$
										.ajax({
											url : "auto",
											type : "post",
											data : '',
											success : function(data) {
												$("input[name='product']")
														.autocomplete({
															autoFocus : true,
															source : data
														})
														.keyup(
																function() {
																	var isValid = false;
																	for (i in data) {
																		if (data[i]
																				.toLowerCase()
																				.match(
																						this.value
																								.toLowerCase())) {
																			isValid = true;
																		}
																	}
																	if (!isValid) {
																		this.value = previousValue
																	} else {
																		previousValue = this.value;
																	}
																});
											},
											error : function(data, status, er) {
												console.log(data + "_" + status
														+ "_" + er);
											},
										});
							});
			$(document).on("keypress",
					":input:not(textarea):not([type=submit])", function(event) {
						if (event.keyCode == 13) {
							event.preventDefault();
						}
					});
		});
	</script>
</head>
<body>
	<div class="form-container">
		<div class="form-box">
			<h2>Нова рецепта:</h2>

			<form action="save_recipe" id="mainform" method="post"
				name="recipe_data">
				<p class="form-title">Име на рецептата:</p>
				<input class="form-field" type="text" name="recipe_name"
					placeholder="Име" required="required">
				<p class="form-title">Продукти:</p>
				<table id="products_table">
					<tr>
						<td class="input_lables">Име на продукт:</td>
						<td class="input_lables">Количество:</td>
						<td></td>
					</tr>
					<tr>
						<td><input id="product_input" type="text"
							placeholder="Продукт" class="form-field_product" name="product"></td>
						<td><input type="number" id="quantity_input"
							placeholder="g/ml" class="form-field_quantity"
							name="quantity_input"></td>
						<td><button type="button" class="white_button"
								onclick="addProduct('products_table')">Добави</button></td>
					</tr>
				</table>
				<div>
					<p class="form-title">Начин на приготвяне:</p>
					<textarea class="form-field_description" id="description"
						name="description" required="required"></textarea>
				</div>
				<label for="picture" class="form-title">Снимка:</label><input
					style="padding: 3px;" type="file" name="image" required="required" />
				<input id="send" class="brown_button" type="submit"
					value="Публикувай рецептата">
			</form>

		</div>
	</div>

</body>


</html>