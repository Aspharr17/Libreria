package controlador.acciones;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Autor;
import DBHelper.Categoria;
import DBHelper.Libro;
import dao.AutorDAO;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;

/**
 * Servlet implementation class FormularioEditarLibro
 */
@WebServlet("/FormularioEditarLibro")
public class FormularioEditarLibroAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		
		
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		Libro libro = libroDAO.buscarPorClave(isbn);
		AutorDAO autorDAO = new AutorDAOJPAImpl();
		List<Autor> listaDeAutores =  autorDAO.buscarTodos();
		
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeAutores", listaDeAutores);

		request.setAttribute("libro", libro);

		return "FormularioEditarLibro.jsp";
	}
	

}
