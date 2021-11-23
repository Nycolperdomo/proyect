<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
<h1>Registrar Afectada</h1>

<form method="post" action="RolController?accion=addA">
  	
  	<div class="form-group">
  		<label for="email">Correo</label>
  		<input type="text" class="form-control" name="correo" id="correo" placeholder="Ingrese el correo"/>
  	</div>
  	
  		<div class="form-group">
  		<label for="password">Contraseña</label><br>
  		<input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="Ingrese la contraseña"/>
  	</div>
  	
  	<div class="form-check">
  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
  <label class="form-check-label" for="flexCheckChecked">
    Activo
  </label>
</div>
  	
  	<div class="form-group">
			<label for="cargo">Cargo Usuario</label>
			 <select class="form-select" name="cargo">
				<option>Seleccione el cargo del Usuario</option>
				<option>Abogada</option>
				<option>Psicologa</option>
				<option>Cliente</option>
				
			</select>
  	

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>

</body>
</html>