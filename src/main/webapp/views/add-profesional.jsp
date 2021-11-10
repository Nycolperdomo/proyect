<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar Profesional</h1>

<form method="post" action="ProfesionalController?accion=add">
  	
  	<div class="form-group">
  		<label for="email">Correo</label>
  		<input type="text" class="form-control" name="correo" id="correo" placeholder="Ingrese el correo"/>
  	</div>
  	
  		<div class="form-group">
  		<label for="password">Contraseña</label><br>
  		<input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="Ingrese la contraseña"/>
  	</div>
  	

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>

<%@include file="footer.jsp" %>
