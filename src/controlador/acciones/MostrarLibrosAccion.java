package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import interfaces.ServicioAutores;
import interfaces.ServicioCategorias;
import interfaces.ServicioLibros;


/**
 * Servlet implementation class MostrarLibro
 */
public class MostrarLibrosAccion extends Accion {
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		ServicioLibros servicioLib = (ServicioLibros)getBean("servicioLibros", request);
		ServicioCategorias servicioCat = (ServicioCategorias)getBean("servicioCategorias",request);
		ServicioAutores servicioAut = (ServicioAutores)getBean("servicioAutores",request);
		request.setAttribute("listaDeLibros", servicioLib.buscarTodosLosLibros());
		request.setAttribute("listaDeCategorias",servicioCat.buscarCategoriasLibros());
		request.setAttribute("listaDeAutores",servicioAut.buscarAutoresLibros());
		return "MostrarLibros.jsp";
	}


}
