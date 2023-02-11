$(document).ready(function(){
	$("#buttonAddCart").on("click", function(e){
		add2Cart();
	});
});

function add2Cart(){
	alert("si");
	cantidad = $("#cantidad" + idProducto).val();
	
	url = contextPath + "/carrito/add/" + idProducto + "/" + cantidad;
	
	$.ajax({
		type : "POST",
		url: url,
		beforeSend: function(xhr){
			xhr.setRequestHeader(crsfHeaderName, crsfValue);
		}
	}).done(function(response){
		$("#modalTitle").text("Carrito de Compras");
		$("#modalBody").text(response);
		$("#myModal").modal();
	}).fail(function(){
		$("#modalTitle").text("Carrito de Compras");
		$("#modalBody").text("Error");
		$("#myModal").modal();
	});
}