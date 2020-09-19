package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import entidades.ServicioLibrosImpl;
import interfaces.ServicioLibros;

/**
 * Servlet implementation class MostrarLibro
 */
public class MostrarLibroAccion extends Accion {
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		ServicioLibros servicioLibros= new ServicioLibrosImpl();
		
		request.setAttribute("listaDeLibros", servicioLibros.buscarTodosLosLibros());
		request.setAttribute("listaDeCategorias",servicioLibros.buscarCategoriasLibros());
		return "MostrarLibros.jsp";
	}


}
