package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import entidades.Libro;
import interfaces.ServicioLibros;

/**
 * Servlet implementation class BorrarLibro
 */
public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		ServicioLibros servicioLib = (ServicioLibros)getBean("servicioLibros", request);
		servicioLib.borrarLibro(new Libro(Integer.parseInt(request.getParameter("isbn"))));

		return "MostrarLibros.do";
	}

}
