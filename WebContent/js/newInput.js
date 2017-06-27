var number = 0; /* Set Global Variable i */
function increment() {
	number += 1; /*
					 * Function for automatic increment of field's "Name"
					 * attribute.
					 */
}

function newProduct() {
	var r = document.createElement('span');
	var product = document.createElement("INPUT");
	product.setAttribute("type", "text");
	product.setAttribute("placeholder", "Продукт");
	product.setAttribute("class", "form-field_product");
	var quantity = document.createElement("INPUT");
	quantity.setAttribute("type", "text");
	quantity.setAttribute("placeholder", "Количество");
	quantity.setAttribute("class", "form-field_quantity");
	increment();
	product.setAttribute("Name", "product_" + number);
	quantity.setAttribute("Name", "quantity_" + number);
	r.appendChild(product);
	r.appendChild(quantity);
	var button = document.createElement("IMG");
	button.setAttribute("src", "../img/delete.png");
	button.setAttribute("onclick", "removeElement('product','id_" + number
			+ "')");
	button.setAttribute("class", "remove_button");
	r.appendChild(button);
	r.setAttribute("id", "id_" + number);
	r.setAttribute("class", "product_input");
	document.getElementById("product").appendChild(r);
}

function newRow(tableID) {
	var table = document.getElementById(tableID);
	var rowCount = table.getElementsByTagName("tr").length;
	var row = table.insertRow(rowCount);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var product = document.createElement("INPUT");
	product.setAttribute("type", "text");
	product.setAttribute("id", "product_tag");
	product.setAttribute("placeholder", "Продукт");
	product.setAttribute("class", "form-field_product");
	var quantity = document.createElement("INPUT");
	quantity.setAttribute("type", "text");
	quantity.setAttribute("placeholder", "Количество");
	quantity.setAttribute("class", "form-field_quantity");
	product.setAttribute("Name", "product_");
	product.setAttribute("autocomplete", "off");
	quantity.setAttribute("Name", "quantity");
	cell1.appendChild(product);
	cell2.appendChild(quantity);
	var button = document.createElement("IMG");
	button.setAttribute("src", "../img/delete.png");
	increment();
	row.setAttribute("id", "id_" + number);
	button.setAttribute("onclick", "deleteRow('id_" + number + "')");
	button.setAttribute("class", "remove_button");
	cell3.appendChild(button);
}

function deleteRow(rowID) {
	var row = document.getElementById(rowID);
	var table = row.parentNode;
	while (table && table.tagName != 'TABLE')
		table = table.parentNode;
	if (!table)
		return;
	table.deleteRow(row.rowIndex);
}

function addProduct(tableID) {
	increment();
	var table = document.getElementById(tableID);
	var rowCount = table.getElementsByTagName("tr").length;
	var row = table.insertRow(rowCount);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var product = document.createElement('output');
	product.innerHTML = document.getElementById("product_input").value;
	product.setAttribute("Name", "product_tag");
	product.setAttribute("class", "list_product");
	product.setAttribute("value",
			document.getElementById("product_input").value);
	var quantity = document.createElement('output');
	quantity.innerHTML = document.getElementById("quantity_input").value;
	quantity.setAttribute("class", "list_product");
	quantity.setAttribute("value",
			document.getElementById("quantity_input").value);
	quantity.setAttribute("Name", "quantity_tag");
	cell1.appendChild(product);
	cell2.appendChild(quantity);
	var button = document.createElement("IMG");
	button.setAttribute("src", "img/delete.png");
	button.setAttribute("onclick", "deleteRow('id_" + number + "')");
	button.setAttribute("class", "remove_button");
	cell3.appendChild(button);
	row.setAttribute("id", "id_" + number);
	$('#product_input').val('');
	$('#quantity_input').val('');
}

function resetElements() {
	document.getElementById('myForm').innerHTML = '';
}

function postArrays() {
	var arrayProducts = [];
	var arrayQuantities = [];
	var products = document.getElementsByName("product_tag");
	for (var i = 0; i < products.length; i++) {
		arrayProducts.push(products[i].value);
	}
	var quantities = document.getElementsByName("quantity_tag");
	for (var i = 0; i < quantities.length; i++) {
		arrayQuantities.push(quantities[i].value);
	}
	var productsList = "";
	var quantitiesList = "";
	for (index = 0; index < arrayProducts.length; ++index) {
		if (index == 0) {
			productsList = arrayProducts[index];
		} else {
			productsList = productsList + "$" + arrayProducts[index];
		}
	}
	for (index = 0; index < arrayQuantities.length; ++index) {
		if (index == 0) {
			quantitiesList = arrayQuantities[index];
		} else {
			quantitiesList = quantitiesList + "$" + arrayQuantities[index];
		}
	}
	document.getElementById('hiddenProductsField').value = productsList;
	document.getElementById('hiddenQuantitiesField').value = quantitiesList;
	document.myform.submit();
}
