package controlador.acciones;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import interfaces.ServicioAutores;
import interfaces.ServicioCategorias;
import interfaces.ServicioLibros;

public class FiltrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		
		/*Set<String> setDeFiltros = request.getParameterMap().keySet();
		request.setAttribute("listaDeLibros", servicioLib.filtrarLibros(setDeFiltros,request));*/
		
		ServicioLibros servicioLib = (ServicioLibros)getBean("servicioLibros", request);
		ServicioCategorias servicioCat = (ServicioCategorias)getBean("servicioCategorias",request);
		ServicioAutores servicioAut = (ServicioAutores)getBean("servicioAutores",request);
		
		int id_cat = Integer.parseInt(request.getParameter("sel_categoria"));
		request.setAttribute("listaDeCategorias", servicioCat.buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", servicioAut.buscarAutoresLibros());
		request.setAttribute("listaDeLibros", servicioLib.buscarLibrosPorCategoria(servicioCat.buscarCategoriaPorClave(id_cat)));
		return "MostrarLibros.jsp";
	}


}
