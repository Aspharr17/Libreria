package controlador.acciones;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import entidades.ServicioLibrosImpl;
import interfaces.ServicioLibros;

/**
 * Servlet implementation class FormularioInsertarLibroAccion
 */
@WebServlet("/FormularioInsertarLibroAccion")
public class FormularioInsertarLibroAccion extends Accion 
{
	

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		ServicioLibros servicioLibros = new ServicioLibrosImpl();

		request.setAttribute("listaDeCategorias", servicioLibros.buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", servicioLibros.buscarAutoresLibros());
		
		return "FormularioInsertarLibro.jsp";
	}

}
