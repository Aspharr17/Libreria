package controlador.acciones;

import java.util.Set;

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
		
		Set<String> setDeFiltros = request.getParameterMap().keySet();
		
		ServicioLibros servicioLib = (ServicioLibros)getBean("servicioLibros", request);
		ServicioCategorias servicioCat = (ServicioCategorias)getBean("servicioCategorias",request);
		ServicioAutores servicioAut = (ServicioAutores)getBean("servicioAutores",request);
		
		request.setAttribute("listaDeCategorias", servicioCat.buscarCategoriasLibros());
		request.setAttribute("listaDeAutores", servicioAut.buscarAutoresLibros());
		request.setAttribute("listaDeLibros", servicioLib.filtrarLibros(setDeFiltros,request));
		return "MostrarLibros.jsp";
	}


}
