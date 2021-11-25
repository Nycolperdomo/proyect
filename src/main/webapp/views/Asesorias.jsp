<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Tipos de asesoria</h1>

<a href="TipoAsesoriaController?accion=abrirForm" class="btn btn-success" role="button">Agregar</a>

<table class="table table-bordered table-hover" id="datat">
	
	<tr>
		<th>Id</th>
		<th>Tipo</th>
		
		<th colspan="2">Acciones</th>
	</tr>
	
	<c:forEach items="${asesorias}" var="r">
	
		<tr>
			<td>${r.getIDasesoria()}</td>
			<td>${r.getTipo()}</td>
			
		</tr>
	</c:forEach>

</table>

</div>

<!-- datatable  -->
<script>


var myTable = document.querySelector("#datat");
var dataTable = new DataTable("#datat", {
    perPage:5,
    labels: {
        placeholder: "Buscar...",
        perPage: "{select} Registros por pagina",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});
</script>

<%@include file="footer.jsp" %>