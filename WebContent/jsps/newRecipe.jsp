<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Нова рецепта</title>
<script src="../js/newInput.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/newRecipe.css">
<link rel="stylesheet" href="../css/jquery-ui.css">
<script src="../js/jquery-1.11.2.js"></script>
<script src="../js/jquery-ui.js"></script>

</head>
<body>
	<script>
	previousValue = "";
		$(function() {
			$("input[name='product']").keypress(function() {
				$.ajax({
					url : "../auto",
					type : "post",
					data : '',
					success : function(data) {
						$("input[name='product']").autocomplete({
							autoFocus: true,
						    source: data
						}).keyup(function() {
						    var isValid = false;
						    for (i in data) {
						        if (data[i].toLowerCase().match(this.value.toLowerCase())) {
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
						console.log(data + "_" + status + "_" + er);
					},
				});
			});	
			$('html').bind('keypress', function(e) {
				if (e.keyCode == 13) {
					return false;
				}
			});
		});
		
	</script>
</head>
<body>
	<div class="form-container">
		<div class="form-box">
			<h2>Нова рецепта:</h2>

			<form action="saveRecipe" id="mainform" method="post"
				name="recipe_data">
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
						<td><input id="product_tag" type="text" placeholder="Продукт"
							class="form-field_product" name="product"></td>
						<td><input type="text" placeholder="Количество"
							class="form-field_quantity" name="quantity_0"></td>
						<td></td>
					</tr>
				</table>
				<button type="button" class="white_button"
					onclick="newRow('products_table')">Нов продукт</button>
				<input class="brown_button" type="submit"
					value="Публикувай рецептата">
			</form>

		</div>
	</div>

</body>


</html>