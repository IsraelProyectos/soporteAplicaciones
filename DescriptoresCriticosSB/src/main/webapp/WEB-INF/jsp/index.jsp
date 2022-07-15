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

			<form method="post">
				<br> <br>
				<button formaction="listar" onClick="barraBusqueda()" type="submit"
					name="esquema" value="funda" class="btn btn-primary">Añadir/Borrar
					descriptor</button>
				<button formaction="listar" onClick="barraBusqueda('funda')"
					type="submit" name="esquema" value="funda" class="btn btn-success">Críticos
					de fundamenta</button>
				<button formaction="listar" onClick="barraBusqueda('cotiz')"
					type="submit" name="esquema" value="cotiz" class="btn btn-success">Críticos
					de cotizaciones</button>
				<button formtarget="_blank" formaction="mostrar" type="submit" class="btn btn-primary">Extraer
					datos para mail</button>
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
									style="border: 2px solid black; color: black; font-size: 0.74rem; background-color: #DCDCDC"><c:out
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
	<br>
	<br>
	<br>
	<br>
</body>
</html>