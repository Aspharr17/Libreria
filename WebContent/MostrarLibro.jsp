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
<form action="MostrarLibro.jsp">

<select name = "sel_categoria" id ="sel_categoria">
<option value = "seleccionar" >Seleccionar</option>

<%
	List<String> listaDeCategorias=null;
	listaDeCategorias=Libro.buscarTodasLasCategorias();
	pageContext.setAttribute("listaDeCategorias",listaDeCategorias);
%>
	<c:forEach var="categoria" items ="${listaDeCategorias}">
		<option value = "${categoria}">${categoria}</option>
	</c:forEach>
</select>

<input type = "submit" value = "Filtrar" name ="filtrar"/>

<%
	List<Libro> listaDeLibros=null;
	
	if (request.getParameter("sel_categoria")==null || request.getParameter("sel_categoria").equals("seleccionar")) 
	{
		listaDeLibros=Libro.buscarTodos();
	
	}
	else 
	{
		listaDeLibros=Libro.buscarPorCategoria(request.getParameter("sel_categoria"));

	}
	pageContext.setAttribute("listaDeLibros",listaDeLibros);	

%>
<br/>
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
		<td><a href="BorrarLibro.jsp?isbn=${libro.getIsbn()}">Borrar</a>
		<a href="FormularioEditarLibro.jsp?isbn=${libro.getIsbn()}">Editar</a></td>	
	</tr>
	</c:forEach>	
	
</table>

</form>
<br />
<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>