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
  	<title> Huitacas.com </title>
</head>
<body>
	<header>
 		<div class="contenedor"> 
 			<h1> Huitacas </h1>
 			<input type="checkbox" id="menu-bar">
 			<label class="icon-menu" for="menu-bar"></label>
 			<nav class="menu">
 				<a href="">Inicio</a>
                 <a href="">Iniciar Sesion</a>
 				<a href="">Registrar Cuenta Afectada</a>
 				
 		</div>
 	</header>

 		<main>
 			<section id="banner">
 				<img src="img/banner.jpg">
 				<div class="contenedor"> 
 					<h2> Huitacas Gestor Administrativo </h2>
 					<p> Porque como mujeres nos importas, te escuchamos y acompaÃ±amos</p>
 					<a href="#"> Leer mas </a>
 				</div>
 			</section>
 			<section id= "bienvenidos">
 				<h2> Bienvenidos a  nuestra pagina Web Huitacas </h2>
 				<p> <CENTER>Somos un grupo de mujeres en pie de lucha por defender nuestros derechos <br>
 				nos capasitamos de la mejor manera con profesionales adnegadas para brindar el acompañamiento necesario<br>
 				con el fin de terminar con la injusticia  <br>
 				</CENTER>
 			</section>	
 			<section id="blog">
 				<h3> Lo Ultimo del Mes </h3>
 				<div class="contenedor">
 					<article>
 						<img src="img/Lucha.jpg">
 						<h4> Lucha morada</h4>
 					</article>
 					<article>
 						<img src="img/biblioteca.jpg">
 						<h4>Bibloteca Fem</h4>
 					</article>
 					<article>
 						<img src="img/fem.png">
 						<h4> Femenicidios </h4>
 					</article>
 				</div>
 			</section>	
 			<section id="info">
 				<h3> Redes Sociales  </h3>
 				<div class="contenedor">
 					<div class="info-un">
 						<img src="img/instagram.jpg" alt="">
 						<h4>INTAGRAM</h4>
 					</div>
 					<div class="info-un">
 						<img src="img/TWI.png" alt="">
 						<h4>TWITTER</h4>
 					</div>
 					<div class="info-un">
 						<img src="img/FACE.png" alt="">
 						<h4>FACEBOOK</h4>
 					</div>
 				</div>
 			</section>
 		</main>   
 		<footer>
 			<div class="contenedor">
 				<p class="copy"> Huitacas &copy; 2021 </p>
 				<div class="sociales">
 					<a class="icon-facebook" href="https://www.facebook.com/BEISBOLERAS/"></a>
 					<a class="icon-twitter-squared" href="#"></a>
 					<a class="icon-instagram" href="#"></a>
 					<a class="icon-googleplus-rect" href="#"></a>



 				</div>
 		</footer>	








<!--  <h1>Aplication cargada</h1>-->


<a href="RolController?accion=listarRoles" class="btn btn-primary" role="button">Ir a Usuarios</a>

<a href="ProfesionalController?accion=listar" class="btn btn-secondary" role="button">Ir a profesionales</a>

<a href="AfectadaController?accion=listar" class="btn btn-success" role="button">Ir a afectadas</a>


<a href="CargoController?accion=listar" class="btn btn-success" role="button">Ir a cargos</a>

<a href="RolController?accion=abrirLogin" class="btn btn-success" role="button">login</a>
<!--  <a href="ProfesionalController?accion=abrirLogin" class="btn btn-success" role="button">login</a>-->


</body>
</html>