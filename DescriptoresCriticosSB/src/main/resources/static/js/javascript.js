function barraBusqueda(esquema) {     
    $("#barraBusqueda").attr('disabled', 'disabled');
    llenarBarra(esquema);
}

function llenarBarra(esquema) {

    setTimeout(function ()
    {
	
		$(':button').prop('disabled', true);
		if (esquema == 'funda') {
			$('#esquema_escogido').parent().html("Críticos de fundamenta");
	        $('#header2').css('display','none');
	        $('#content').css('display','none');
	        $("#divBarra").append("<div class='progress' style='width: 50%; margin: 0 auto'><div class='progress-bar progress-bar-striped bg-success progress-bar-animated' role='progressbar' aria-valuenow='75' aria-valuemin='0' aria-valuemax='50' style='width: 100%'>BUSCANDO CRÍTICOS DE FUNDAMENTA</div></div>");
        } else {
			$('#esquema_escogido').parent().html("Críticos de cotiz");
			$('#header2').css('display','none');
	        $('#content').css('display','none');
	        $("#divBarra").append("<div class='progress' style='width: 50%; margin: 0 auto'><div class='progress-bar progress-bar-striped bg-success progress-bar-animated' role='progressbar' aria-valuenow='75' aria-valuemin='0' aria-valuemax='50' style='width: 100%'>BUSCANDO CRÍTICOS DE COTIZACIONES</div></div>");  
		}
    },1000)
}

$(document).ready(function() {
    $("#cerrar").click(function(){
        alert("button");
    }); 
});

function copiarAportapapeles() {
	var copiarTexto = document.getElementById('copiarPortapapeles');
	var seleccion = document.createRange();
	seleccion.selectNodeContents(copiarTexto);
	window.getSelection().removeAllRanges();
	window.getSelection().addRange(seleccion);
	var res = document.execCommand('copy');
	window.getSelection().removeRange(seleccion);
}
