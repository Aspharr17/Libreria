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
 * Servlet implementation class FiltrarLibros
 */

public class FiltrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");

		
		LibroDAO libroDAO = factoria.getLibroDAO();
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		
		List<Libro> listaDeLibros = null;
		
		if (request.getParameter("sel_categoria")==null || request.getParameter("sel_categoria").equals("seleccionar")) 
		{
			listaDeLibros = libroDAO.buscarTodos();
		}
		else 
		{
			Categoria categoria = new Categoria();
			int id_cat = Integer.parseInt(request.getParameter("sel_categoria"));
			categoria = categoriaDAO.buscarPorClave(id_cat);
			listaDeLibros =libroDAO.buscarPorCategoria(categoria);

		}
		
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeLibros", listaDeLibros);
		return "MostrarLibros.jsp";
	}


}
