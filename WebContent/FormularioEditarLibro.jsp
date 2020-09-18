<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List"%>
<%@ page import="DBHelper.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));
%>
<title>Editar</title>
        <script src ="validation.js" type ="text/javascript"></script>
        <meta http-equiv ="Content-Type" content="text/html;charset=UTF-8"/></head>
<head>Editar Libro</head>
<body>
	<form id = "formularioEdicion" action ="GuardarLibro.jsp">
		<fieldset>
		<p>
			<label for ="clave">ISBN: </label>
			<input type = "text" name ="isbn" id = "isbn" value = <%=libro.getIsbn() %> />
		</p>
		<p>	
			<label for = "titulo">Titulo: </label>
			<input type = "text" name = "titulo" id ="titulo"value =<%=libro.getTitulo()%>/>
		</p>
		<p>
			<label for =  "categoria"> Categoria: </label>
			<input type = "text" name = "categoria" id = "categoria" value = <%=libro.getCategoria()%>/>
		</p>
		<p>
			<input type = "submit" value = "Guardar" onclick = "validar('edit');"/>
		</p>
		</fieldset>
	

	</form>
</body>
</html>