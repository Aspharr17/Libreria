package controlador.acciones;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Autor;
import DBHelper.Categoria;
import DBHelper.Libro;

/**
 * Servlet implementation class FormularioEditarLibro
 */
@WebServlet("/FormularioEditarLibro")
public class FormularioEditarLibroAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		Libro libro = Libro.buscarPorClave(isbn);
		List<Categoria> listaDeCategorias = null;
		List<Autor> listaDeAutores = null;
		listaDeAutores = Autor.buscarTodos();
		listaDeCategorias = Categoria.buscarTodos();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeAutores", listaDeAutores);

		request.setAttribute("libro", libro);

		return "FormularioEditarLibro.jsp";
	}
	

}
