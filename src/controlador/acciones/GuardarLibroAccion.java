package controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import entidades.Autor;
import entidades.Categoria;
import entidades.Libro;
import interfaces.ServicioLibros;
/**
 * Servlet implementation class GuardarLibro
 */
public class GuardarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{

		ServicioLibros servicioLib = (ServicioLibros)getBean("servicioLibros", request);

		servicioLib.salvarLibro(new Libro(Integer.parseInt(request.getParameter("isbn")),
												request.getParameter("titulo"),
												new Autor(Integer.parseInt(request.getParameter("autor"))),
												new Categoria(Integer.parseInt(request.getParameter("categoria"))))
										);
			return "MostrarLibros.do";
	}


}
