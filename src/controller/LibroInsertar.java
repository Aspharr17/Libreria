package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBHelper.*;
/**
 * Servlet implementation class LibroInsertar
 */
@WebServlet(name = "LibroInsertar", urlPatterns = {"/LibroInsertar"})
public class LibroInsertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Setea la salida como html
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try
		{
			//SUSTITUYE AL JSP InstertarLibro
			int isbn = Integer.parseInt( request.getParameter("isbn"));
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			Libro libro = new Libro(isbn, titulo, categoria);
			libro.insertar();
			//MUESTRA PAGINA DE OPCIONES PARA SEGUIR INSERTANDO O MOSTRAR LOS LIBROS
			String page = "<html>"
						+ "<head>"
						+ "<title>Registro realizado</title>"
						+ "</head>"
						+ "<h1> Se registró el libro "+titulo+" correctamente</h1>"
						+ "<a href=\"FormularioInsertarLibro.jsp\">Insertar Libro</a>"
						+ "<br/>"
						+ "<a href=\"MostrarLibro.jsp\">MostrarLibro </a>"
						+ "</body>"
						+ "</html>";
			out.println(page);
			
			
		}catch(DBException e)
		{
			out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
		
	}

}
