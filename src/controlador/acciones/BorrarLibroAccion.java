package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import abstractas.DAOAbstractFactory;
import entidades.Libro;
import interfaces.DAOFactory;
import interfaces.LibroDAO;

/**
 * Servlet implementation class BorrarLibro
 */
public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//SUSTITUYE AL JSP InstertarLibro
			String isbn= request.getParameter("isbn");
			Libro libro= new Libro();
			
			DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");
			
			LibroDAO libroDAO = factoria.getLibroDAO();
			libro.setCve_lib(Integer.parseInt(isbn));
			libroDAO.borrar(libro);

		return "MostrarLibro.do";
	}

}
