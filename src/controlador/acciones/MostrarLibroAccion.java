package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import dao.JPA.ServicioCategoriasImpl;
import dao.JPA.ServicioLibrosImpl;

/**
 * Servlet implementation class MostrarLibro
 */
public class MostrarLibroAccion extends Accion {
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		
		//ServicioLibros servicioLibros= new ServicioLibrosImpl();
		//ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		
		request.setAttribute("listaDeLibros", new ServicioLibrosImpl().buscarTodosLosLibros());
		request.setAttribute("listaDeCategorias",new ServicioCategoriasImpl().buscarCategoriasLibros());
		return "MostrarLibros.jsp";
	}


}
