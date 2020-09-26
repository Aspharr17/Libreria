package controlador.acciones;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import dao.JPA.ServicioAutoresImpl;
import dao.JPA.ServicioCategoriasImpl;
import dao.JPA.ServicioLibrosImpl;

/**
 * Servlet implementation class FormularioEditarLibro
 */
@WebServlet("/FormularioEditarLibro")
public class FormularioEditarLibroAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		/*ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		ServicioAutores servicioAutores = new ServicioAutoresImpl();
		 */
		request.setAttribute("listaDeCategorias", new ServicioCategoriasImpl().buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", new ServicioAutoresImpl().buscarAutoresLibros());
		request.setAttribute("libro",new ServicioLibrosImpl().buscarLibroPorClave(Integer.parseInt(request.getParameter("isbn"))));

		return "FormularioEditarLibro.jsp";
	}
	

}
