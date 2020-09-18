package controlador.acciones;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Libro;

/**
 * Servlet implementation class FormularioEditarLibro
 */
@WebServlet("/FormularioEditarLibro")
public class FormularioEditarLibroAccion extends Accion 
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");

		Libro libro = Libro.buscarPorClave(isbn);
		request.setAttribute("listaDeCategorias", libro.buscarTodasLasCategorias());
		request.setAttribute("libro", libro);

		return "FormularioEditarLibro.jsp";
	}
	

}
