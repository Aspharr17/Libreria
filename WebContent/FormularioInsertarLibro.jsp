<?xml version = "1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<script src ="js/validation.js" type ="text/javascript"></script>
    <meta http-equiv ="Content-Type" content="text/html;charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
        
<body>

<form action = "LibroInsertar.do">
<fieldset id= "fs">
	<legend>Formulario alta libro</legend>
	<p>
		<label for ="clave">ISBN: </label>
		<input type = "text" name ="isbn" id = "isbn" />
	</p>
	<p>
		<label for = "titulo">Titulo: </label>

		<input type = "text" name = "titulo" id ="titulo"/>
	</p>
	<p>
		<label for =  "categoria"> Categoria: </label>

		<input type = "text" name = "categoria" id = "categoria"/>
	</p>
	<p>
		<input type = "submit" id ="btnInsert" value = "Insertar" />
	</p>
</fieldset>
</form>
</body>
</html>