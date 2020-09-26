package controlador.acciones;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import dao.JPA.ServicioAutoresImpl;
import dao.JPA.ServicioCategoriasImpl;

/**
 * Servlet implementation class FormularioInsertarLibroAccion
 */
@WebServlet("/FormularioInsertarLibroAccion")
public class FormularioInsertarLibroAccion extends Accion 
{
	

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		//ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		//ServicioAutores servicioAutores = new ServicioAutoresImpl();

		request.setAttribute("listaDeCategorias", new ServicioCategoriasImpl().buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", new ServicioAutoresImpl().buscarAutoresLibros());
		
		return "FormularioInsertarLibro.jsp";
	}

}
