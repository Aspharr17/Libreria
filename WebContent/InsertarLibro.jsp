<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DBHelper.*"%>

<% 


	try
	{	
		int isbn = Integer.parseInt( request.getParameter("isbn"));
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Libro libro = new Libro(isbn, titulo, categoria);
		libro.insertar();	
		response.sendRedirect("MostrarLibro.jsp");
		
	}catch(DBException e)
	{%>
		<%=e.getMessage()%>
	<% }

    
%>
