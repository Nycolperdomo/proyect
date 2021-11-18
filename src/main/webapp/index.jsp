<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <h1>Aplication cargada</h1>-->


<a href="RolController?accion=listarRoles" class="btn btn-primary" role="button">Ir a Usuarios</a>

<a href="ProfesionalController?accion=listar" class="btn btn-secondary" role="button">Ir a profesionales</a>

<a href="AfectadaController?accion=listar" class="btn btn-success" role="button">Ir a afectadas</a>


<a href="CargoController?accion=listar" class="btn btn-success" role="button">Ir a cargos</a>

<a href="RolController?accion=abrirLogin" class="btn btn-success" role="button">login</a>
<!--  <a href="ProfesionalController?accion=abrirLogin" class="btn btn-success" role="button">login</a>-->


</body>
</html>