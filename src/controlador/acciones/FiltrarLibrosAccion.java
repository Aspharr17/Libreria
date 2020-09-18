package controlador.acciones;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Libro;

/**
 * Servlet implementation class FiltrarLibros
 */

public class FiltrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Libro libro = new Libro ();
		List<Libro> listaDeLibros = null;
		if (request.getParameter("sel_categoria")==null || request.getParameter("sel_categoria").equals("seleccionar")) 
		{
			listaDeLibros = libro.buscarTodos();
		}
		else 
		{
			listaDeLibros =Libro.buscarPorCategoria(request.getParameter("sel_categoria"));

		}
		request.setAttribute("listaDeCategorias", libro.buscarTodasLasCategorias());
		request.setAttribute("listaDeLibros", listaDeLibros);
		return "MostrarLibro.jsp";
	}


}
