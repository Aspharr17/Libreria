<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  sentencias de import necesarias para jdbc -->
<%@ page import="DBHelper.*"%>

<% 
    //1
	int isbn = Integer.parseInt( request.getParameter("isbn"));
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	Libro libro = new Libro(isbn, titulo, categoria);
	libro.guardar();
	    

	response.sendRedirect("MostrarLibro.jsp");
		
	
    
%>
