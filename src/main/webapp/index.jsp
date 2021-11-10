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
<h1>Aplication cargada</h1>



<div class="row justify-content-center align-items-center vh-100">
	<aside class="col-sm-4">

<div class="card">
<article class="card-body">
<h4 class="card-title mb-4 mt-1">Iniciar sesion</h4>
	 <form>
    <div class="form-group">
    	<label>Correo</label>
    	
    	<div class="input-group">
      <div class="input-group-text">@</div>
      <input type="email" class="form-control" id="autoSizingInputGroup" placeholder="correo">
    </div>
    	
    	
 
    <div class="form-group">
    
    	<label>Contraseña</label>
        <input class="form-control" placeholder="******" type="password">
        
    	<a class="float-right" href="#">Olvidaste tu contraseña?</a>
    	<br>
    </div> <!-- form-group// --> 
    <div class="form-group"> 
    <div class="checkbox">
     <!-- <label> <input type="checkbox"> Save password </label>-->
    </div> <!-- checkbox .// -->
    </div> <!-- form-group// -->  
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Iniciar sesion</button>
        
                <button type="submit" class="btn btn-success btn-block"> Crear Cuenta</button>
    </div> <!-- form-group// -->                                                           
</form>
</article>
</div> <!-- card.// -->

	</aside> <!-- col.// -->
	<aside class="col-sm-4">


<a href="RolController?accion=listarRoles" class="btn btn-primary" role="button">Ir a roles</a>

<a href="ProfesionalController?accion=listar" class="btn btn-secondary" role="button">Ir a profesionales</a>

<a href="AfectadaController?accion=listar" class="btn btn-success" role="button">Ir a afectadas</a>


<a href="CargoController?accion=listar" class="btn btn-success" role="button">Ir a cargos</a>


</body>
</html>