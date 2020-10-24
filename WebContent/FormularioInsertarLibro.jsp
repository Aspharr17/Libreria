<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <!-- Bootstrap CSS --> 
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
         integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
      <script src ="js/validation.js" type ="text/javascript"></script>
      <meta http-equiv ="Content-Type" content="text/html;charset=UTF-8"/>
      <link rel="stylesheet" type="text/css" href="css/styles.css"/>
      <title>Insertar libro</title>
   </head>
   <body>
      <!-- Barra de navegación -->
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
         <a class="navbar-brand" href="#">
         <img src="https://image.freepik.com/vector-gratis/ilustracion-icono-cuaderno_53876-18330.jpg" width="30" height="30" class="d-inline-block align-center" alt="" loading="lazy">
         Librería de Babel
         </a>
         <div class="collapse navbar-collapse" id="navbarSupportedContent" >
            <ul class="nav nav-tabs " style="position:absolute; bottom:0;" >
               <!-- Navegación entre paginas -->
               <li class="nav-item" >
                  <a class = "nav-link" href="MostrarLibros.do">Mostrar Libros</a>
               </li>
               <li class="nav-item">
                  <a class = "nav-link active" href="FormularioInsertarLibro.do">Insertar Libro</a>
               </li>
               <li class="nav-item">
                  <a class = "nav-link" href="#">Autores</a>
               </li>
               <li class="nav-item">
                  <a class = "nav-link" href="#">Categorias</a>
               </li>
            </ul>
         </div>
      </nav>
      <!-- Contenedor de formulario -->
      <div class ="container">
         <div class="col-md-6 offset-md-3">
            <form id ="formInsertar" action = "LibroInsertar.do" onsubmit = "return validar()">
               <h3>Formulario alta libro</h3>
               <div class="form-group">
                  <label for ="clave">ISBN: </label>
                  <input class="form-control" type = "text" name ="isbn" id = "isbn" />
               </div>
               <div class="form-group">
                  <label for = "titulo">Titulo: </label>
                  <input class="form-control" type = "text" name = "titulo" id ="titulo"/>
               </div>
               <div class="form-group">
                  <label for =  "autor"> Autor: </label>
                  <select   class="form-control" name = "autor" id ="autor">
                     <option value = "seleccionar" >Seleccionar</option>
                     <c:forEach var="autor" items ="${listaDeAutores}">
                        <option value = "${autor.id_aut}">${autor.nom_aut}</option>
                     </c:forEach>
                  </select>
               </div>
               <div class="form-group">
                  <label for =  "categoria"> Categoria: </label>
                  <select class ="form-control" name = "categoria" id ="categoria">
                     <option value = "seleccionar" >Seleccionar</option>
                     <c:forEach var="categoria" items ="${listaDeCategorias}">
                        <option value = "${categoria.id_cat}">${categoria.des_cat}</option>
                     </c:forEach>
                  </select>
               </div>
               <p>
                  <input  class="btn btn-primary" type = "submit"  value = "Insertar" />
               </p>
            </form>
         </div>
      </div>
   </body>
   <!-- Optional JavaScript -->
   <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>