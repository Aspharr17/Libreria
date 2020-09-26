package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import dao.JPA.ServicioAutoresImpl;
import dao.JPA.ServicioCategoriasImpl;
import dao.JPA.ServicioLibrosImpl;

public class FiltrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		//ServicioLibros servicioLibros = new ServicioLibrosImpl();
		//ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		//ServicioAutores servicioAutores = new ServicioAutoresImpl();
		
		/*List<Libro> listaDeLibros = servicioLibros.buscarLibrosPorCategoria(
										servicioCategorias.buscarCategoriaPorClave(
												Integer.parseInt(request.getParameter("sel_categoria"))));
		*/
		request.setAttribute("listaDeCategorias", new ServicioCategoriasImpl().buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", new ServicioAutoresImpl().buscarAutoresLibros());
		request.setAttribute("listaDeLibros", new ServicioLibrosImpl().buscarLibrosPorCategoria(
													new ServicioCategoriasImpl().buscarCategoriaPorClave(
														Integer.parseInt(request.getParameter("sel_categoria")))));
		return "MostrarLibros.jsp";
	}


}
