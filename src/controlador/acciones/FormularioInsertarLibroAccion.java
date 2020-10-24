package controlador.acciones;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import interfaces.ServicioAutores;
import interfaces.ServicioCategorias;

/**
 * Servlet implementation class FormularioInsertarLibroAccion
 */
@WebServlet("/FormularioInsertarLibroAccion")
public class FormularioInsertarLibroAccion extends Accion 
{
	

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		ServicioCategorias servicioCat = (ServicioCategorias)getBean("servicioCategorias",request);
		ServicioAutores servicioAut = (ServicioAutores)getBean("servicioAutores",request);
		request.setAttribute("listaDeCategorias", servicioCat.buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", servicioAut.buscarAutoresLibros());
		
		return "FormularioInsertarLibro.jsp";
	}

}
