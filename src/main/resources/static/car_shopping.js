$(document).ready(function() {

	$(".minusButton").on("click", function(evt) {
		evt.preventDefault();
		disminuirCantidad($(this));
	});

	$(".plusButton").on("click", function(evt) {
		evt.preventDefault();
		incrementarCantidad($(this));
	});
	$(".link-remove").on("click", function(evt) {
		evt.preventDefault();
		removeFromCart($(this));
	});
	updateTotal();
});

function removeFromCart(link) {
	url = link.attr("href");

	$.ajax({
		type: "POST",
		url: url,
		beforeSend: function(xhr) {
			xhr.setRequestHeader(crsfHeaderName, crsfValue);
		}
	}).done(function(response) {
		

		$("#modalTitle").text("Carrito de Compras");
		if (response.includes("El producto ha sido removido del Carrito")) {
			$("#myModal").on("hide.bs.modal", function(e) {
				rowNumber = link.attr("rowNumber")
				removeProduct("rowNumber");
				updateTotal();
			});	
		}
		$("#modalBody").text(response);
		$("#myModal").modal();
	}).fail(function() {
		$("#myModal").modal();
		$("#modalTitle").text("Carrito de Compras");
		$("#modalBody").text("Error");
	});
}
function removeProduct(rowNumber) {
	rowId = "row" + rowNumber;
	$("#" + rowId).remove();
}
function disminuirCantidad(link) {
	productId = link.attr("pid");

	cantidadInput = $("#cantidad" + productId);

	newCantidad = parseInt(cantidadInput.val()) - 1;

	if (newCantidad > 0) {
		cantidadInput.val(newCantidad);
		updateCantidad(productId, newCantidad);

	}
}
function incrementarCantidad(link) {
	productId = link.attr("pid");

	cantidadInput = $("#cantidad" + productId);

	newCantidad = parseInt(cantidadInput.val()) + 1;

	if (newCantidad < 10) {
		cantidadInput.val(newCantidad);
		updateCantidad(productId, newCantidad);
	}
}
function updateCantidad(idProducto, cantidad) {
	url = contextPath + "carrito/update/" + idProducto + "/" + cantidad;

	$.ajax({
		type: "POST",
		url: url,
		beforeSend: function(xhr) {
			xhr.setRequestHeader(crsfHeaderName, crsfValue);
		}
	}).done(function(newSubtotal) {
		updateSubtotal(newSubtotal, productId);
		updateTotal();
	}).fail(function() {
		$("#modalTitle").text("Carrito de Compras");
		$("#modalBody").text("Error");
		$("#myModal").modal();
	});

}
function updateSubtotal(newSubtotal, productId) {
	$("#subtotal" + productId).text(newSubtotal);
}
function updateTotal() {

	total = 0.0;

	$(".productSubtotal").each(function(index, element) {
		total = total + parseFloat(element.innerHTML);
	});

	$("#totalEstimado").text("$" + total);
}