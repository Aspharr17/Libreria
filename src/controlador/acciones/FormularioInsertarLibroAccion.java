package controlador.acciones;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Autor;
import DBHelper.Categoria;

/**
 * Servlet implementation class FormularioInsertarLibroAccion
 */
@WebServlet("/FormularioInsertarLibroAccion")
public class FormularioInsertarLibroAccion extends Accion 
{
	

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Categoria> listaDeCategorias = null;
		List<Autor> listaDeAutores = null;
		listaDeCategorias = Categoria.buscarTodos();
		listaDeAutores = Autor.buscarTodos();
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeAutores", listaDeAutores);
		return "FormularioInsertarLibro.jsp";
	}

}
