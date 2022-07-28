<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Descriptores criticos</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript">
	$(window).on('load', function() {
		var my_js_data = '<c:out value="${primeraCargaPagina}"/>';
		if (my_js_data) {
			$('#anadirBorrarDescriptor').modal('show');
		}
	});
</script>
<style type="text/css">
body {
	background-color: #696969;
}

#header1 {
	position: fixed;
	top: 0;
	width: 100%;
	font-size: 20px;
	color: #FFFFFF;
}

#header2 {
	position: fixed;
	width: 100%;
}

#content {
	width: 100%;
}

.cuadradoNaranja {
	width: 0.5em;
	background-color: orange;
}

.cuadradoRojo {
	width: 0.5em;
	background-color: #E53131;
}
</style>
</head>
<body style="background-color: #fcfce3">
	<div id="header1" style="text-align: center">
		<div style="background-color: #333">
			<!-- cambio -->
			<form method="post">
				<br> <br>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#anadirBorrarDescriptor">Añadir/Borrar
					descriptor</button>
				<button formaction="listar" onClick="barraBusqueda('funda')"
					type="submit" name="esquema" value="funda" class="btn btn-success">Críticos
					de fundamenta</button>
				<button formaction="listar" onClick="barraBusqueda('cotiz')"
					type="submit" name="esquema" value="cotiz" class="btn btn-success">Críticos
					de cotizaciones</button>
				<!-- <button formtarget="_blank" formaction="mostrar" type="submit"
					class="btn btn-primary">Extraer datos para mail</button> -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#extraerDatos">Extraer datos para mail</button>
				<br> <br>
			</form>
		</div>
		<!-- mostramos el titulo de que esquema estamos mostrando los datos-->
		<c:choose>
			<c:when test='${basededatos == 1}'>
				<c:set value='Críticos de fundamenta' var='esquema' />
			</c:when>
			<c:when test='${basededatos == 2}'>
				<c:set value='Críticos de cotiz' var='esquema' />
			</c:when>
			<c:otherwise>
				<c:set value='SIN DATOS' var='esquema' />
			</c:otherwise>
		</c:choose>
		<div style="background-color: #fcfce3;">
			<table style="margin: 0 auto;">
				<tr>
					<td></td>
					<td
						style="align-items: center; font-weight: bold; font-family: cursive; color: black; font-size: 0.625em; background-color: fcfce3"></td>
					<td
						style="align-items: center; font-weight: bold; font-family: cursive; color: black; font-size: 0.625em; background-color: fcfce3"></td>
					<td
						style="align-items: center; font-weight: bold; font-family: cursive; color: black; font-size: 0.625em; background-color: fcfce3"></td>
					<td></td>
				</tr>
				<tr>
					<td
						style="font-weight: bold; font-family: cursive; color: black; font-size: 0.625em; background-color: #fcfce3"><span
						id="esquema_escogido"><c:out value="${esquema}" /></span><br>
						<br></td>
				</tr>
			</table>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="divBarra" style="width: 100%"></div>
	<c:if test="${mostrar != null}">
		<div id="header2">
			<table style="margin: 0 auto; width: 85%">
				<tr>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Descriptor</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Última
						fecha cargada</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">País
						de origen</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Origen
						del dato</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Día
						de carga</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Tipo
						de carga</td>
				</tr>
			</table>
		</div>

		<div id="content">
			<table style="margin: 0 auto; width: 85%">
				<tr>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Descriptor</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Última
						fecha cargada</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">País
						de origen</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Origen
						del dato</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Día
						de carga</td>
					<td
						style="border: 2px solid black; color: white; font-size: 1.0rem; background-color: green">Tipo
						de carga</td>
				</tr>
				<c:choose>
					<c:when test="${descriptores != null}">
						<c:forEach var="descriptor" items="${descriptores}">
							<tr>
								<td
									style="border: 2px solid black; color: black; font-size: 0.74rem; background-color: #DCDCDC"><c:out
										value="${descriptor.cddescriptor}" /></td>
								<td
									style="border: 2px solid black; color: black; font-size: 0.74rem; background-color: #DCDCDC"><c:out
										value="${descriptor.fechaInicio}" /></td>
								<td
									style="border: 2px solid black; color: black; font-size: 0.74rem; background-color: #DCDCDC"><c:out
										value="${descriptor.nomPais}" /></td>
								<td
									style="border: 2px solid black; color: black; font-size: 0.70rem; background-color: #DCDCDC"><c:out
										value="${descriptor.nomOrigen}" /></td>
								<td
									style="border: 2px solid black; color: black; font-size: 0.74rem; background-color: #DCDCDC"><c:out
										value="${descriptor.dia}" /></td>
								<td
									style="border: 2px solid black; color: black; font-size: 0.74rem; background-color: #DCDCDC"><c:out
										value="${descriptor.cargaDescriptor}" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td colspan="6"
							style="border: 2px solid black; text-align: center; color: black; font-size: 0.74rem; background-color: #DCDCDC"><c:out
								value="No hay descriptores críticos fuera de fechas" /></td>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</c:if>
	<div class="modal fade" id="anadirBorrarDescriptor"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="anadirBorrarDescriptor">Añadir/Borrar
						descriptor</h5>
					<!-- <button formmethod="post" formaction="borrarVariables" type="submit" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button> -->
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<input type="text" placeholder="Escoge el número de descriptor"
								class="form-control" name="descriptor" required>
						</div>
						<div class="form-group">
							<select class="form-control" name="diaCarga" required>
								<option value="">Selecciona el día de carga</option>
								<option>Cotiz D+1 Diarios</option>
								<option>Cotiz D-2 Diarios</option>
								<option>Fundamenta D-2</option>
								<option>Cotiz D-1 Diarios</option>
								<option>Fundamenta D-1</option>
								<option>Cotiz D-1 Laborables</option>
								<option>Cotiz mensual</option>
							</select>
						</div>
						<button type="submit" formaction="borrarVariables" class="btn btn-secondary" formnovalidate>Cerrar</button>
						<button type="submit" formmethod="post"
							formaction="anadir_borrar_descriptor" name="accion" value="guardar" class="btn btn-primary">Guardar
							descriptor</button>
						<button type="submit" formmethod="post" 
							formaction="anadir_borrar_descriptor" name="accion" value="borrar" class="btn btn-danger">Borrar
							descriptor</button>
					</form>
				</div>
				<div style="color: red;">
					<c:out value="${mensajeIntroduccion}" />
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="extraerDatos"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog" style="max-width: 70% !important;">
			<div class="modal-content">

					

				<div class="modal-header">
				<h5 class="modal-title" id="extraerDatos">Mail de descriptores</h5>
					
					<button type="button" data-dismiss="modal" class="btn btn-secondary">Cerrar</button>
					
					<button type="submit" class="btn btn-success">Copiar al portapapeles</button>

					
				</div>
				<div class="modal-body">
				<c:choose>
					<c:when test="${txt != null}">
						<c:forEach var="texto" items="${txt}">
							<c:out value="${texto}" /><br><br>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:out value="No se ha ejecutado ninguna busqueda aun"></c:out>
					</c:otherwise>
				</c:choose>
					
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
</body>
</html>