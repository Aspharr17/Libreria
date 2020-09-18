package controlador.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.Libro;

/**
 * Servlet implementation class MostrarLibro
 */
public class MostrarLibroAccion extends Accion {
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Libro libro = new Libro ();
		request.setAttribute("listaDeCategorias", libro.buscarTodasLasCategorias());
		request.setAttribute("listaDeLibros", libro.buscarTodos());
		
		return "MostrarLibro.jsp";
	}


}
