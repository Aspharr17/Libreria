package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import abstractas.DAOAbstractFactory;
import entidades.Autor;
import entidades.Categoria;
import entidades.Libro;
import interfaces.DAOFactory;
import interfaces.LibroDAO;
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
			
			DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");
			
			LibroDAO libroDAO = factoria.getLibroDAO();
			libroDAO.guardar(new Libro(isbn,titulo,
											new Autor(Integer.parseInt(request.getParameter("autor"))),
											new Categoria(Integer.parseInt(request.getParameter("categoria")))));	
			
			return "MostrarLibro.do";
	}


}
