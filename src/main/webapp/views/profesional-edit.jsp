<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Usuario</h1>

<form method="post" action="ProfesionalController?accion=edit">


  	<div class="form-group">
  		<input type="text" class="form-control" name="id" id="id" placeholder="" value="${profesional.IDprofesional}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${profesional.nombre}"/>
  	</div>
  	<div class="form-group">
  		<label for="apellido">Apellido</label>
  		<input type="text" class="form-control" name="apellido" id="apellido" placeholder="Ingrese apellido" value="${profesional.apellido}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="telefono">Telefono</label>
  		<input type="texto" class="form-control" name="telefono" id="telefono" placeholder="Ingrese numero telefonico" value="${profesional.telefono}"/>
  	</div>
  	
  	<div class="form-group">
			<label for="tipodoc">Tipo Documento</label>
			<!-- SELECT INDISPENSABLE EL NAME -->
			<select name="tipodoc" class="form-select" value="${profesional.tipoDocumento}">
				<option selected>Selecione un tipo de documento</option>
				<option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
				<option value="Cedula de Ciudadania">Cedula de Ciudadania</option>
			</select>
		</div>
		
  	<div class="form-group">
  		<label for="nuDocumento">Numero Documento</label>
  		<input type="texto" class="form-control" name="nuDocumento" id="nuDocumento" placeholder="Ingrese numero de documento" value="${profesional.numeroDocumento}"/>
  	</div>
  	
  	

		<div class="form-group">
			<label for="fechaNa">Fecha Nacimiento</label>
			 <input	class="form-control" type="date" name="fechaNa" placeholder="Ingrese su Fecha de Nacimiento" value="${profesional.fechaNacimiento}"/>
		</div>
		
  	
  		
	 	<div class="form-group">
			<label for="correo">Correo</label> 
			<input class="form-control"	type="email" name="correo"	placeholder="Ingrese su Correo Electronico" value="${profesional.correo}"/>
		</div> 
		
		
  	<div class="form-group">
  		<label for="correo">Contraseña</label>
  		<input type="password" class="form-control" name="password" id="password" placeholder="Ingrese la contraseña" value="${profesional.contraseña}"/>
  	</div>
  	
			<div class="form-group">
			<label for="carpro">Cargo Profesional</label>
			 <select class="form-select" name="carpro">
				<option>Seleccione el cargo del profesional</option>
				<c:forEach items="${cargos}" var="c">
				<option value="${c.IDcargo}">${c.cargo}</option>
				</c:forEach>
			</select>

		</div>
		
  	<div class="form-check">
	  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
	  <c:out value="${profesional.estado==false ? 'unchecked':'checked'}"/> >
	  <label class="form-check-label" for="flexCheckChecked">
	    ${profesional.estado==false ? 'Marca para Activar Profesional':'Desmarca para desactivar Profesional'}
	  </label>
	</div>


<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>