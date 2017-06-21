var i = 0; /* Set Global Variable i */
function increment() {
	i += 1; /* Function for automatic increment of field's "Name" attribute. */
}
/*
 * ---------------------------------------------
 * 
 * Function to Remove Form Elements Dynamically
 * ---------------------------------------------
 * 
 */
function removeElement(parentDiv, childDiv) {
	if (childDiv == parentDiv) {
		alert("The parent div cannot be removed.");
	} else if (document.getElementById(childDiv)) {
		var child = document.getElementById(childDiv);
		var parent = document.getElementById(parentDiv);
		parent.removeChild(child);
	} else {
		alert("Child div has already been removed or does not exist.");
		return false;
	}
}
/*
 * ----------------------------------------------------------------------------
 * 
 * Functions that will be called upon, when user click on the Name text field.
 * 
 * ----------------------------------------------------------------------------
 */
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
	product.setAttribute("Name", "product_" + i);
	quantity.setAttribute("Name", "quantity_" + i);
	r.appendChild(product);
	r.appendChild(quantity);
	var button = document.createElement("IMG");
	button.setAttribute("src", "../img/delete.png");
	button.setAttribute("onclick", "removeElement('product','id_" + i + "')");
	button.setAttribute("class", "remove_button");
	r.appendChild(button);
	r.setAttribute("id", "id_" + i);
	r.setAttribute("class", "product_input");
	document.getElementById("product").appendChild(r);
}
/*
 * -----------------------------------------------------------------------------
 * 
 * Functions that will be called upon, when user click on the E-mail text field.
 * 
 * ------------------------------------------------------------------------------
 */
function newRow(tableID) {
	increment();
	var table = document.getElementById(tableID);
	var rowCount = table.getElementsByTagName("tr").length;
	var row = table.insertRow(rowCount);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var product = document.createElement("INPUT");
	product.setAttribute("type", "text");
	product.setAttribute("placeholder", "Продукт");
	product.setAttribute("class", "form-field_product");
	var quantity = document.createElement("INPUT");
	quantity.setAttribute("type", "text");
	quantity.setAttribute("placeholder", "Количество");
	quantity.setAttribute("class", "form-field_quantity");
	product.setAttribute("Name", "product_" + i);
	quantity.setAttribute("Name", "quantity_" + i);
	cell1.appendChild(product);
	cell2.appendChild(quantity);
	var button = document.createElement("IMG");
	button.setAttribute("src", "../img/delete.png");
	button.setAttribute("onclick", "deleteRow('id_" + i + "')");
	button.setAttribute("class", "remove_button");
	cell3.appendChild(button);
	row.setAttribute("id", "id_" + i);
}

function deleteRow(rowID) {
	   var row = document.getElementById(rowID);
	    var table = row.parentNode;
	    while ( table && table.tagName != 'TABLE' )
	        table = table.parentNode;
	    if ( !table )
	        return;
	    table.deleteRow(row.rowIndex);
}
/*
 * -----------------------------------------------------------------------------
 * 
 * Functions that will be called upon, when user click on the Contact text
 * field.
 * 
 * ------------------------------------------------------------------------------
 */
function contactFunction() {
	var r = document.createElement('span');
	var y = document.createElement("INPUT");
	y.setAttribute("type", "text");
	y.setAttribute("placeholder", "Contact");
	var g = document.createElement("IMG");
	g.setAttribute("src", "delete.png");
	increment();
	y.setAttribute("Name", "textelement_" + i);
	r.appendChild(y);
	g.setAttribute("onclick", "removeElement('myForm','id_" + i + "')");
	r.appendChild(g);
	r.setAttribute("id", "id_" + i);
	document.getElementById("myForm").appendChild(r);
}
/*
 * -----------------------------------------------------------------------------
 * 
 * Functions that will be called upon, when user click on the Message textarea
 * field.
 * 
 * ------------------------------------------------------------------------------
 */
function textareaFunction() {
	var r = document.createElement('span');
	var y = document.createElement("TEXTAREA");
	var g = document.createElement("IMG");
	y.setAttribute("cols", "17");
	y.setAttribute("placeholder", "message..");
	g.setAttribute("src", "delete.png");
	increment();
	y.setAttribute("Name", "textelement_" + i);
	r.appendChild(y);
	g.setAttribute("onclick", "removeElement('myForm','id_" + i + "')");
	r.appendChild(g);
	r.setAttribute("id", "id_" + i);
	document.getElementById("myForm").appendChild(r);
}
/*
 * -----------------------------------------------------------------------------
 * 
 * Functions that will be called upon, when user click on the Reset Button.
 * 
 * ------------------------------------------------------------------------------
 */
function resetElements() {
	document.getElementById('myForm').innerHTML = '';
}