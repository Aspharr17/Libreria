package controlador.acciones;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Autor;
import DBHelper.Categoria;
import dao.AutorDAO;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;

/**
 * Servlet implementation class FormularioInsertarLibroAccion
 */
@WebServlet("/FormularioInsertarLibroAccion")
public class FormularioInsertarLibroAccion extends Accion 
{
	

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
			
		CategoriaDAO categoriaDAO = new CategoriaDAOJPAImpl();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		AutorDAO autorDAO = new AutorDAOJPAImpl();
		List<Autor> listaDeAutores =  autorDAO.buscarTodos();
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeAutores", listaDeAutores);
		return "FormularioInsertarLibro.jsp";
	}

}
