package controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import abstractas.DAOAbstractFactory;
import entidades.Categoria;
import entidades.Libro;
import interfaces.CategoriaDAO;
import interfaces.DAOFactory;
import interfaces.LibroDAO;

/**
 * Servlet implementation class MostrarLibro
 */
public class MostrarLibroAccion extends Accion {
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");
		
		LibroDAO libroDAO = factoria.getLibroDAO();
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();

		List<Libro> listaDeLibros = libroDAO.buscarTodos();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "MostrarLibros.jsp";
	}


}
