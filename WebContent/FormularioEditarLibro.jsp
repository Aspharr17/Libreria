<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">

<head>
	<title>Editar</title>
	<script src ="js/validation.js" type ="text/javascript"></script>
    <meta http-equiv ="Content-Type" content="text/html;charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
<body>
	<form action ="GuardarLibro.do"  onsubmit = "return validar()" >
		<fieldset>
			<p>
				<label for ="clave">ISBN: </label>
				<input type = "text" name ="isbn" id = "isbn" value = "${libro.getCve_lib()}" />
			</p>
			<p>	
				<label for = "titulo">Titulo: </label>
				<input type = "text" name = "titulo" id ="titulo"value ="${libro.getTit_lib()}" />
			</p>
				<p>	
				<label for = "autor">Autor: </label>
			<select name = "autor" id ="autor">
				<option value = "seleccionar" >Seleccionar</option>
				<c:forEach var="autor" items ="${listaDeAutores}">
				<option value = "${autor.id_aut}">${autor.nom_aut}</option>
			</c:forEach>
			</select>					
			</p>
	
			<select name = "categoria" id ="categoria">
				<option value = "seleccionar" >Seleccionar</option>
				<c:forEach var="categoria" items ="${listaDeCategorias}">
				<option value = "${categoria.id_cat}">${categoria.des_cat}</option>
				</c:forEach>
			</select>	
		
			<p>
				<input type = "submit" value = "Guardar" />
			</p>
		</fieldset>
	</form>
</body>
</html>