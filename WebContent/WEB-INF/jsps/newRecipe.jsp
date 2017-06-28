<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Нова рецепта</title>
<link rel="stylesheet" type="text/css" href="css/newRecipe.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/newInput.js" type="text/javascript"></script>
<script src="js/jquery-1.11.2.js"></script>
<script src="js/jquery-ui.js"></script>

</head>
<script>
	previousValue = "";
	$(function() {
		$("input[name='product']").keypress(
				function() {
					$.ajax({
						url : "auto",
						type : "post",
						data : '',
						success : function(data) {
							$("input[name='product']").autocomplete({
								autoFocus : true,
								source : data
							}).keyup(
									function() {
										var isValid = false;
										for (i in data) {
											if (data[i].toLowerCase().match(
													this.value.toLowerCase())) {
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
		$(document).on("keypress", ":input:not(textarea):not([type=submit])",
				function(event) {
					if (event.keyCode == 13) {
						event.preventDefault();
					}
				});
	});
</script>
</head>
<body>
	<jsp:useBean id="filds" class="com.javabeans.FormNewRecipe" />
	<jsp:useBean id="cookieManager" class="com.javabeans.CookiesManager" />
	<%
		Cookie[] cookies = request.getCookies();
		if (!cookieManager.isUserCorrect(cookies)) {
			response.sendRedirect("signin");
		}
	%>
	<div class="form-container" >
		<div class="form-box">
			<h2>Нова рецепта:</h2>

			<form action="save_recipe" id="mainform" method="post"
				name="recipe_data" enctype="multipart/form-data">
				<p class="form-title">Име на рецептата:</p>
				<input class="form-field" type="text"
					name="<%=filds.getRecipeTitleInputName()%>" placeholder="Име"
					required="required">
				<p class="form-title">Продукти:</p>
				<table id="products_table">
					<tr>
						<td class="input_lables">Име на продукт:</td>
						<td class="input_lables">Количество:</td>
						<td></td>
					</tr>
					<tr>
						<td><input id="product_input" type="text"
							placeholder="Продукт" class="form-field_product"
							name="<%=filds.getProductsInputName()%>"></td>
						<td><input type="number" id="quantity_input"
							placeholder="g/ml" class="form-field_quantity"
							name="<%=filds.getQuantityInputName()%>" min="1"></td>
						<td><button type="button" class="white_button"
								onclick="addProduct('products_table')">Добави</button></td>
					</tr>
				</table>
				<div>
					<p class="form-title">Начин на приготвяне:</p>
					<textarea class="form-field_description" id="description"
						name="<%=filds.getCookingDescriptionInputName()%>"
						required="required"></textarea>
				</div>
				<table>
					<tr class="time_cell">
						<td class="time_cell_label">
							<p class="form_title_time">Брой порции:</p>
						</td>
						<td><input class="form-field_quantity" type="number" min="1"
							max="20" name="<%=filds.getPortionsInputName()%>"
							placeholder="бр." required="required"></td>
					</tr>
					<tr>
						<td class="time_cell_label">
							<p class="form_title_time">Време за приготвяне:</p>
						</td>
						<td><input class="form-field_time" type="time"
							name="<%=filds.getTimeInputName()%>" placeholder="min."
							required="required"></td>
					</tr>
				</table>
				<table>
					<tr class="rating_cell">
						<td class="form-title">Ниво на трудност:</td>
						<td style="vertical-align: middle"><input class="star star1"
							id="radio1" type="radio" name=<%=filds.getDifficultyInputName()%>
							value="1"><label class="star star1" for="radio1"></label>
							<input class="star star2" id="radio2" type="radio"
							name=<%=filds.getDifficultyInputName()%> value="2"> <label
							class="star star2" for="radio2"></label> <input
							class="star star3" id="radio3" type="radio"
							name=<%=filds.getDifficultyInputName()%> value="3"> <label
							class="star star3" for="radio3"></label> <input
							class="star star4" id="radio4" type="radio"
							name=<%=filds.getDifficultyInputName()%> value="4"> <label
							class="star star4" for="radio4"></label> <input
							class="star star5" id="radio5" type="radio"
							name=<%=filds.getDifficultyInputName()%> value="5"> <label
							class="star star5" for="radio5"></label></td>
					</tr>
				</table>
				<div>
					<input type="hidden" name="hiddenProductsField"
						id="hiddenProductsField" value="" /> <input type="hidden"
						name="hiddenQuantitiesField" id="hiddenQuantitiesField" value="" />
				</div>
				<label for="picture" class="form-title">Снимка:</label><input
					style="padding: 3px;" type="file"
					name="<%=filds.getImageInputName()%>" required="required" /> <input
					id="send" class="brown_button" type="submit"
					value="Публикувай рецептата" onclick="postArrays()">
			</form>
			<p id="demo"></p>
		</div>
	</div>
</body>


</html>