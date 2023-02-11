function eliminar(){

	var idProducto = document.getElementById("txt_id").value;
	location.href="/admin/proveedor/eliminar/" + idProducto;
	
}

function confirmar(idProducto){
	document.getElementById("txt_id").value=idProducto;

}

$(document).ready(function () {
    $('#example').DataTable();
});