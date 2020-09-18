package controlador.acciones;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import abstractas.DAOAbstractFactory;
import entidades.Autor;
import entidades.Categoria;
import interfaces.AutorDAO;
import interfaces.CategoriaDAO;
import interfaces.DAOFactory;

/**
 * Servlet implementation class FormularioInsertarLibroAccion
 */
@WebServlet("/FormularioInsertarLibroAccion")
public class FormularioInsertarLibroAccion extends Accion 
{
	

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
			
		DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");
		
		
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		
		AutorDAO autorDAO = factoria.getAutorDAO();
		List<Autor> listaDeAutores =  autorDAO.buscarTodos();
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeAutores", listaDeAutores);
		return "FormularioInsertarLibro.jsp";
	}

}
