<?xml version = "1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<!--  omitimos JS y cabecera -->
<title>Ejemplo01</title>
        <script src ="validation.js" type ="text/javascript"></script>
        <meta http-equiv ="Content-Type" content="text/html;charset=UTF-8"/></head>
<body>
<form>
<fieldset>
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
		<input type = "submit" value = "Insertar" onclick = "validar();"/>
	</p>
</fieldset>
</form>
</body>
</html>