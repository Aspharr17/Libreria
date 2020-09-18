<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DBHelper.*"%>

<% 
	int isbn = Integer.parseInt( request.getParameter("isbn"));
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	try
	{
		Libro libro = new Libro(isbn, titulo, categoria);
		libro.guardar();	
		response.sendRedirect("MostrarLibro.jsp");
	}catch(Exception e)
	{%>
		<%=e.getMessage()%>	
	<% }
	
%>
