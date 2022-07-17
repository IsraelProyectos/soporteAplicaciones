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
				<button type="submit" name="esquema" value="funda"
					class="btn btn-success" formaction="http://localhost:9090/DescriptoresCriticosSB">Descriptores críticos</button>
				<button type="submit" name="esquema" value="funda"
					class="btn btn-success" formaction="http://localhost:9090/VisorHuecosSpringBoot">Visor de huecos</button>
				<br> <br>
			</form>
		</div>
	</div>	
</body>
</html>