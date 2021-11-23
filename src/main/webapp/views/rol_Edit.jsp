<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar Rol</h1>

<form method="post" action="RolController?accion=add">
  	
  	<div class="form-group">
  		<label for="email">Correo</label>
  		<input type="text" class="form-control" name="correo" id="correo" placeholder="Ingrese el correo"/>
  	</div>
  	
  		<div class="form-group">
  		<label for="password">Contraseņa</label><br>
  		<input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="Ingrese la contraseņa"/>
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

<%@include file="footer.jsp" %>
