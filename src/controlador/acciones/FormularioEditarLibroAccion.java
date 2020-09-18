package controlador.acciones;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import abstractas.DAOAbstractFactory;
import entidades.Autor;
import entidades.Categoria;
import entidades.Libro;
import interfaces.AutorDAO;
import interfaces.CategoriaDAO;
import interfaces.DAOFactory;
import interfaces.LibroDAO;

/**
 * Servlet implementation class FormularioEditarLibro
 */
@WebServlet("/FormularioEditarLibro")
public class FormularioEditarLibroAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		
		DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");
		
		LibroDAO libroDAO = factoria.getLibroDAO();
		Libro libro = libroDAO.buscarPorClave(isbn);
		
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		
		AutorDAO autorDAO = factoria.getAutorDAO();
		List<Autor> listaDeAutores =  autorDAO.buscarTodos();
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeAutores", listaDeAutores);

		request.setAttribute("libro", libro);

		return "FormularioEditarLibro.jsp";
	}
	

}
