package controlador.acciones;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import abstractas.DAOAbstractFactory;
import entidades.Libro;
import entidades.ServicioLibrosImpl;
import interfaces.DAOFactory;
import interfaces.LibroDAO;
import interfaces.ServicioLibros;

public class FiltrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		
		DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");
		LibroDAO libroDAO = factoria.getLibroDAO();
		
		List<Libro> listaDeLibros = libroDAO.buscarPorCategoria(
										servicioLibros.buscarCategoriaPorClave(
											Integer.parseInt(request.getParameter("sel_categoria"))));

		
		request.setAttribute("listaDeCategorias",servicioLibros.buscarCategoriasLibros());
		request.setAttribute("listaDeLibros", listaDeLibros);
		return "MostrarLibros.jsp";
	}


}
