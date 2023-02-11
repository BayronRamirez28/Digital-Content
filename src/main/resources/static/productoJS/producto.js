function eliminar(){

	var idProducto = document.getElementById("txt_id").value;
	location.href="/admin/producto/eliminar/" + idProducto;
	
}

function confirmar(idProducto){
	document.getElementById("txt_id").value=idProducto;

}

$(document).ready(function () {
    $('#tableP').DataTable();
});