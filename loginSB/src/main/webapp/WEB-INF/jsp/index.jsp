<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<style type="text/css">
#cover {
    background: linear-gradient(150deg, rgba(0,128,0,1) 0%, rgba(0,0,128,1) 100%, rgba(0,212,255,1) 100%);
    background-size: cover;
    height: 100%;
    text-align: center;
    display: flex;
    align-items: center;
    position: relative;
}

#cover-caption {
    width: 100%;
    position: relative;
    z-index: 1;
}

/* only used for background overlay not needed for centering */
form:before {
    content: '';
    height: 100%;
    left: 0;
    position: absolute;
    top: 0;
    width: 100%;
    background-color: rgba(0,0,0,0.3);
    z-index: -1;
    border-radius: 10px;
}

}
</style>
<title>Login</title>
</head>
<body class="">
	<section id="cover" class="min-vh-100">
    <div id="cover-caption">
        <div class="container">
            <div class="row text-white">
                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                    <p class="display-4 py-2 text-truncate">Gestion de tareas<br> de Soporte</p>
                    <div class="px-2">
                        <form action="GestionTareasSoporte" method="post">
                            <div class="form-group">
                                <input type="text" name="usuario" class="form-control" placeholder="Introduce tu usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" placeholder="Introduce tu password">
                            </div>
                            <button type="submit" class="btn btn-primary btn-lg">ENTRAR</button>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
        <div style="color: red;"><c:out value="${errorLogin}" /></div>
    </div>
    
</section>
</body>
</html>