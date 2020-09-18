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
 * Servlet implementation class FiltrarLibros
 */

public class FiltrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		
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
