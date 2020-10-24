package controlador.acciones;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import interfaces.ServicioAutores;
import interfaces.ServicioCategorias;
import interfaces.ServicioLibros;

/**
 * Servlet implementation class FormularioEditarLibro
 */
@WebServlet("/FormularioEditarLibro")
public class FormularioEditarLibroAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		
		ServicioLibros servicioLib = (ServicioLibros)getBean("servicioLibros", request);
		ServicioCategorias servicioCat = (ServicioCategorias)getBean("servicioCategorias",request);
		ServicioAutores servicioAut = (ServicioAutores)getBean("servicioAutores",request);
		
		request.setAttribute("listaDeCategorias", servicioCat.buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", servicioAut.buscarAutoresLibros());
		request.setAttribute("libro",servicioLib.buscarLibroPorClave(Integer.parseInt(request.getParameter("isbn"))));

		return "FormularioEditarLibro.jsp";
	}
	

}
