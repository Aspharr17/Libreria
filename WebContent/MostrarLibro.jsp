<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DBHelper.*" %>
    <%@ page import="java.util.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/styles.css">

<title>Lista de libros</title>
</head>
<body>
<form action="MostrarLibro.jsp" method="post">

<select name = "categoria" id ="categoria">
<option value = "seleccionar" >Seleccionar</option>
<%
	List<String> listaDeCategorias=null;
	listaDeCategorias=Libro.buscarTodasLasCategorias();
	String cat;
	for(String categoria:listaDeCategorias) { 
		%>
		<option value="<%=categoria%>"><%=categoria%></option>
				
	<% }%>
	
	

</select>
<input type = "submit" value = "Filtrar" ></input>

<br/>
<%
	List<Libro> listaDeLibros=null;
	if (request.getParameter("categoria")==null || request.getParameter("categoria").equals("seleccionar")) 
	{
		listaDeLibros=Libro.buscarTodos();
	}
	else 
	{
		listaDeLibros=Libro.
		buscarPorCategoria(request.getParameter("categoria"));
	}
	%>
<table id ="tb_lib">
	<tr>
	<th>ISBN</th>
	<th>Título</th>
	<th>Categoría</th>
	</tr>
	<%
	for(Libro libro:listaDeLibros){ %>
	<tr>
		<td><%=libro.getIsbn()%></td>
		<td><%=libro.getTitulo()%></td>
		<td><%=libro.getCategoria()%></td>
		
		<td><a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn()%>">Borrar</a></td>
		<td><a href="FormularioEditarLibro.jsp?isbn=<%=libro.getIsbn()%>">Editar</a></td>

	
	<% }
%>
</table>
<br/>
<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</form>
</body>
</html>