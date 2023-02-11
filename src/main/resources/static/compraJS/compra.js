$(document).ready(function () {
    $('#exampleS').DataTable();
});


function eliminar(){

	var idBarrio = document.getElementById("txt_id").value;
	location.href="/admin/barrio/eliminare/" + idBarrio;
	
}

function confirmar(idBarrio){
	document.getElementById("txt_id").value=idBarrio;

}