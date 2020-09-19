package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import entidades.Libro;
import entidades.ServicioLibrosImpl;
import interfaces.ServicioLibros;

/**
 * Servlet implementation class BorrarLibro
 */
public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//SUSTITUYE AL JSP InstertarLibro
		
		ServicioLibros servicioLibros= new ServicioLibrosImpl();
		servicioLibros.borrarLibro(new Libro(Integer.parseInt(request.getParameter("isbn"))));

		return "MostrarLibro.do";
	}

}
