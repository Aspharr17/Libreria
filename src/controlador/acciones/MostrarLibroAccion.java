package controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Categoria;
import DBHelper.Libro;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;

/**
 * Servlet implementation class MostrarLibro
 */
public class MostrarLibroAccion extends Accion {
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();

		List<Libro> listaDeLibros = libroDAO.buscarTodos();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "MostrarLibros.jsp";
	}


}
