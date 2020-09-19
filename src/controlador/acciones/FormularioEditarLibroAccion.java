package controlador.acciones;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import entidades.ServicioLibrosImpl;
import interfaces.ServicioLibros;

/**
 * Servlet implementation class FormularioEditarLibro
 */
@WebServlet("/FormularioEditarLibro")
public class FormularioEditarLibroAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		
		request.setAttribute("listaDeCategorias", servicioLibros.buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", servicioLibros.buscarAutoresLibros());
		
		request.setAttribute("libro", servicioLibros.buscarLibroPorClave(Integer.parseInt(request.getParameter("isbn"))));

		return "FormularioEditarLibro.jsp";
	}
	

}
