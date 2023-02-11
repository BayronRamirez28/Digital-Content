$(document).ready(function(){
	$(".minusButton").on("click", function(evt){
		evt.preventDefault();
		productId = $(this).attr("pid");
		
		cantidadInput = $("#cantidad" + productId);
		
		newCantidad = parseInt(cantidadInput.val()) - 1; 
		
		if(newCantidad > 0 ) cantidadInput.val(newCantidad);
	});
	
	$(".plusButton").on("click", function(evt){
		evt.preventDefault();
		productId = $(this).attr("pid");
		
		cantidadInput = $("#cantidad" + productId);
		
		newCantidad = parseInt(cantidadInput.val()) + 1; 
		
		if(newCantidad < 10 ) cantidadInput.val(newCantidad);
	});		
});