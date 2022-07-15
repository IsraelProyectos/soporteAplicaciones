function barraBusqueda(esquema) {     
    $("#barraBusqueda").attr('disabled', 'disabled');
    llenarBarra(esquema);
}

function llenarBarra(esquema) {

    setTimeout(function ()
    {
		$(':button').prop('disabled', true);
		if (esquema == 'funda') {
			$('#esquema_escogido').parent().html("HUECOS DE FUNDAMENTA");
	        $('#header2').css('display','none');
	        $('#content').css('display','none');
	        $("#divBarra").append("<div id='divfillmeUp' class='progress' style='width: 50%; margin: 0 auto'><div class='progress-bar progress-bar-striped bg-success progress-bar-animated' role='progressbar' aria-valuenow='75' aria-valuemin='0' aria-valuemax='50' style='width: 100%'>BUSCANDO HUECOS DE FUNDAMENTALES</div></div>");
        } else {
			$('#esquema_escogido').parent().html("HUECOS DE COTIZACIONES");
			$('#header2').css('display','none');
	        $('#content').css('display','none');
	        $("#divBarra").append("<div id='divfillmeUp' class='progress' style='width: 50%; margin: 0 auto'><div class='progress-bar progress-bar-striped bg-success progress-bar-animated' role='progressbar' aria-valuenow='75' aria-valuemin='0' aria-valuemax='50' style='width: 100%'>BUSCANDO HUECOS DE COTIZACIONES</div></div>");
		}
    },1000)
}
