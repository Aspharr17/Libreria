<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DBHelper.*" %>
    <%@ page import="java.util.*" %>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/styles.css"/>

<title>Lista de libros</title>
</head>
<body>
<form action="FiltrarLibros.do">

<select name = "sel_categoria" id ="sel_categoria">
<option value = "seleccionar" >Seleccionar</option>

	<c:forEach var="categoria" items ="${listaDeCategorias}">
		<option value = "${categoria}">${categoria}</option>
	</c:forEach>
</select>

<input type = "submit" value = "Filtrar"/>

<br/>
</form>

<table id ="tb_lib">
	<tr>
		<th>ISBN</th>
		<th>Título</th>
		<th>Categoría</th>
		<th>Opciones</th>
	</tr>
	
	<c:forEach var="libro" items ="${listaDeLibros}">
	<tr>
		<td><c:out value="${libro.getIsbn()}"></c:out></td>
		<td><c:out value="${libro.getTitulo()}"></c:out></td>
		<td><c:out value="${libro.getCategoria()}"></c:out></td>
		<td><a href = "BorrarLibro.do?isbn=${libro.isbn}">Borrar</a></td>
		<td><a href="FormularioEditarLibro.do?isbn=${libro.getIsbn()}">Editar</a></td>	
	</tr>
	</c:forEach>	
	
</table>

<br />
<a href="FormularioInsertarLibro.do">Insertar Libro</a>
</body>
</html>