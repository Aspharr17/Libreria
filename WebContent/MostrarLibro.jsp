<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="DBHelper.*" %>
    <%@ page import="java.sql.ResultSet" %>
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
<option value = "seleccionar">seleccionar</option>
<%
	//DataBaseHelper db = new DataBaseHelper();
	//String consultaSQL = "select isbn, titulo, categoria from libros";
	//3 y 4
	Libro libro = new Libro();
	ResultSet rs = null;
	try{
	 rs = libro.buscarTodasLasCategorias();
	//5
	while(rs.next()){%>
	

	<option value ="<%=rs.getString("categoria")%>">
	<%=rs.getString("categoria") %></option>
	<%}
	}
	finally{}%>
</select>
<br/>

<%
	List<Libro> listaDeLibros = libro.buscarTodos();
	for(Libro lib:listaDeLibros){%>
	<%=lib.getIsbn()%>
	<%=lib.getTitulo()%>
	<%=lib.getCategoria()%>
	<br/>
	<%}
	
%>

<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>