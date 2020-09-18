package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBHelper.Libro;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;

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
			LibroDAO libroDAO = new LibroDAOJPAImpl();
			libro.setCve_lib(Integer.parseInt(isbn));
			libroDAO.borrar(libro);

		return "MostrarLibro.do";
	}

}
