package controlador.acciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.DBException;
import DBHelper.Libro;

/**
 * Servlet implementation class BorrarLibro
 */
public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//SUSTITUYE AL JSP InstertarLibro
			String isbn= request.getParameter("isbn");
			Libro libro= new Libro();
			libro.setIsbn(Integer.parseInt(isbn));
			try {
				libro.borrar();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return "MostrarLibro.do";
	}

}
