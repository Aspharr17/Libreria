<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/styles.css"/>
	<script src ="js/validation.js" type ="text/javascript"></script>
	
<title>Lista de libros</title>
</head>
<body>
	<form id = "formFiltro"  onsubmit = "return filtro()">
		<select name = "sel_categoria" id ="sel_categoria">
				<option value = "seleccionar" >Seleccionar</option>
				<c:forEach var="categoria" items ="${listaDeCategorias}">
				<option value = "${categoria.id_cat}">${categoria.des_cat}</option>
			</c:forEach>
		</select>
		<input type = "submit" value = "Filtrar"/>
		<br/>
	</form>
	<table id ="tb_lib">
		<tr>
			<th>ISBN</th>
			<th>Título</th>
			<th>Autor</th>
			<th>Categoría</th>
			<th>Opciones</th>
		</tr>
		<c:forEach var="libro" items ="${listaDeLibros}">
			<tr>
				<td><c:out value="${libro.cve_lib}"></c:out></td>
				<td><c:out value="${libro.tit_lib}"></c:out></td>
				<td><c:out value="${libro.autor.nom_aut}"></c:out></td>
				<td><c:out value="${libro.categoria.des_cat}"></c:out></td>
				
				<td><a href = "BorrarLibro.do?isbn=${libro.cve_lib}">Borrar</a></td>
				<td><a href="FormularioEditarLibro.do?isbn=${libro.getCve_lib()}">Editar</a></td>	
			</tr>
		</c:forEach>	
	</table>
	<br/>
	<a href="FormularioInsertarLibro.do">Insertar Libro</a>
</body>
</html>