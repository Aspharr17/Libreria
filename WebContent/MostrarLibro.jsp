<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DBHelper.*" %>
    <%@ page import="java.util.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de libros</title>
</head>
<body>

<select name = "categoria">
<option value = "seleccionar">Seleccionar</option>
<%
	List<String> listaDeCategorias=null;
	listaDeCategorias=Libro.buscarTodasLasCategorias();
	for(String categoria:listaDeCategorias) { %>
		<option value="<%=categoria%>"><%=categoria%></option>

	<% } 
%>

</select>
<br/>
<table>
  <tr>
    <th>ISBN</th>
    <th>Título</th>
    <th>Categoría</th>
  </tr>
<%
	List<Libro> listaDeLibros=null;
	listaDeLibros=Libro.buscarTodos();
	for(Libro libro:listaDeLibros){ %>
	<tr>
	
		<td><%=libro.getIsbn()%></td>
		<td><%=libro.getTitulo()%></td>
		<td><%=libro.getCategoria()%></td>
		<td><a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn()%>">Borrar</a></td>
		<td><a href="FormularioEditarLibro.jsp?isbn=<%=libro.getIsbn()%>">Editar</a></td>
	</tr>	
		<% }
%>

</table>
<br/>


<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>