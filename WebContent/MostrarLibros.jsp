<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
   "http://www.w3.org/TR/html4/loose.dtd">
<html >
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
   <head>
      <meta charset="utf-8">
      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
         integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" href="css/styles.css">
      <script src ="js/validation.js" type ="text/javascript"></script>
      <title>Lista de libros</title>
   </head>
   <body>
      <!-- Barra de navegación -->
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
         <a class="navbar-brand" href="#">
         <img src="https://image.freepik.com/vector-gratis/ilustracion-icono-cuaderno_53876-18330.jpg"
            width="30" height="30" class="d-inline-block align-center" alt="" loading="lazy">
         Librería de Babel
         </a>
         <div  class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="nav nav-tabs " style="position:absolute; bottom:0;" >
               <!-- Navegación entre paginas -->
               <li class="nav-item ">
                  <a class = "nav-link active"  href="MostrarLibros.do">Mostrar Libros</a>
               </li>
               <li class="nav-item">
                  <a class = "nav-link" href="FormularioInsertarLibro.do">Insertar Libro</a>
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
      <!-- Barra de filtros, los Select deben empezar con "sel_"+nombre del atributo a filtrar-->
      <div class ="d-flex align-items-center">
         <div class="p-2 bd-highlight">
            <h5 >Filtrar por:</h5>
         </div>
         <form id = "formFiltro"  onsubmit = "return filtro()">
         <!--  onchange="seleccion();" 
            <select name = "sel_filtro" id ="sel_filtro">
               <option value = "seleccionar" >Seleccionar</option>
               <option value = "categoria">Categoria</option>
               <option value = "autor">Autor</option>
            </select>
            -->
            <select name = "sel_categoria" id ="sel_categoria" >
               <option value = "seleccionar" >Categoría</option>
               <c:forEach var="categoria" items ="${listaDeCategorias}">
                  <option value = "${categoria.id_cat}">${categoria.des_cat}</option>
               </c:forEach>
            </select>
            <!-- REVISAR SEGUNDO FILTRO -->
            <select name = "sel_autor" id ="sel_autor" >
               <option value = "seleccionar" >Autor</option>
               <c:forEach var="autor" items ="${listaDeAutores}">
                  <option value = "${autor.id_aut}">${autor.nom_aut}</option>
               </c:forEach>
            </select>
            <input type = "submit" class="btn btn-primary"></input>
            <br>
         </form>
      </div>
      <!-- Tabla de datos -->
      <div class="table-responsive">
         <table class="table table-striped" id ="tb_lib">
            <thead class="thead-dark">
               <tr>
                  <th scope="col">ISBN</th>
                  <th scope="col">Título</th>
                  <th scope="col">Autor</th>
                  <th scope="col">Categoría</th>
                  <th scope="col">Opciones</th>
                  <th scope="col"></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="libro" items ="${listaDeLibros}">
                  <tr>
                     <th scope="row">
                        <c:out value="${libro.cve_lib}"></c:out>
                     </th>
                     <td>
                        <c:out value="${libro.tit_lib}"></c:out>
                     </td>
                     <td>
                        <c:out value="${libro.autor.nom_aut}"></c:out>
                     </td>
                     <td>
                        <c:out value="${libro.categoria.des_cat}"></c:out>
                     </td>
                     <td><a href = "BorrarLibro.do?isbn=${libro.cve_lib}">Borrar</a></td>
                     <td><a href="FormularioEditarLibro.do?isbn=${libro.cve_lib}">Editar</a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
   <!-- Optional JavaScript -->
   <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>