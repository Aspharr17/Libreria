<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  sentencias de import necesarias para jdbc -->
<%@ page import="DBHelper.*"%>

<% 
	String isbn= request.getParameter("isbn");
	Libro libro= new Libro();
	libro.setIsbn(Integer.parseInt(isbn));
	libro.borrar();
	response.sendRedirect("MostrarLibro.jsp");
		
	
    
%>
