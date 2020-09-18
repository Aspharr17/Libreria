package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Autor;
import DBHelper.Categoria;
import DBHelper.Libro;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
/**
 * Servlet implementation class GuardarLibro
 */
public class GuardarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
			int isbn = Integer.parseInt(request.getParameter("isbn"));
			String titulo = request.getParameter("titulo");
			Categoria categoria = new Categoria(Integer.parseInt(request.getParameter("categoria")));
			Autor autor = new Autor(Integer.parseInt(request.getParameter("autor")));
			Libro libro = new Libro(isbn, titulo, autor, categoria);	
			LibroDAO libroDAO = new LibroDAOJPAImpl();
			libroDAO.guardar(libro);	
			
			return "MostrarLibro.do";
	}


}
