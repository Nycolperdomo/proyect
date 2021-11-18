<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Afectadas</h1>

<a href="AfectadaController?accion=abrirForm" class="btn btn-success" role="button">Agregar</a>

<table class="table table-bordered table-hover" id="dataTa">
	
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Telefono</th>
		<th>Tipo<br>Documento</th>
		<th>No<br>Documento</th>
		<th>Fecha<br>nacimiento</th>
		<th>Correo</th>
		<th>Estado</th>
	
		<th colspan="2">Acciones</th>
	</tr>
	<!-- (listar)el member esta request.setAttribute("afectadas", afect);para recibir datos (controller) -->
	<c:forEach items="${afectadas}" var="a">	
	
		<tr>
			<td>${a.getIDafectada()}</td>
			<td>${a.getNombre()}</td>
			<td>${a.getApellido()}</td>
			<td>${a.getTelefono()}</td>
			<td>${a.getTipoDocumento()}</td>
			<td>${a.getNumeroDocumento()}</td>
			<td>${a.getFechaNacimiento()}</td>
			<!-- para poner el estado de la tabla que esta relacionada -->
			<td>${a.AfecUs.correo}</td>
			<td>${a.AfecUs.estado}</td>
			
			<c:if test="${a.AfecUs.isEstado()==true}">
				<td><span class="badge bg-success">Activo</span>
					<a class="btn btn-danger btn-sm" onclick="changeEstado(event,${a.getIDafectada()},${a.AfecUs.isEstado()},'Afectada')" role="button">Inactivar</a>
				
				</td>
			</c:if>
			<c:if test="${a.AfecUs.isEstado()==false}">
				<td><span class="badge bg-danger">Inactivo</span>
				
				<a class="btn btn-success btn-sm" onclick="changeEstado(event,${a.getIDafectada()},${a.isEstado()},'Afectada')" role="button">Activar</a>
				</td>
			</c:if>-->
			<td>
			<a class="btn btn-warning" href="AfectadaController?accion=ver&id=${a.getIDafectada()}" role="button">Editar</a>
			<!--invocar una funcion con onclick(borrar es el nombre de la funcion)-->
			<a class="btn btn-danger" onclick="borrar(event,${a.getIDafectada()},'Afectada')" role="button">Borrar</a>
			</td>
		</tr>
	</c:forEach>

</table>

</div>


<!-- datatable  -->

<script>

<!--queryselector para seleccionar la tabla que se va autilizatr , nos permite identificar en este caso por un ID  -->
var myTable = document.querySelector("#dataTa");
<!--inicializar el objeto datatable que tiene js -->
var dataTable = new DataTable("#dataTa", {
    perPage:5,
    labels: {
        placeholder: "Buscar...",
        perPage: "{select} Registros por página",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});

</script>

<%@include file="footer.jsp" %>
