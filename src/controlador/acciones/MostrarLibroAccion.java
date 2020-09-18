package controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Categoria;
import DBHelper.Libro;

/**
 * Servlet implementation class MostrarLibro
 */
public class MostrarLibroAccion extends Accion {
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Libro libro = new Libro ();
		List<Categoria> listaDeCategorias = null;
		listaDeCategorias = Categoria.buscarTodos();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("listaDeLibros", libro.buscarTodos());
		
		return "MostrarLibro.jsp";
	}


}
