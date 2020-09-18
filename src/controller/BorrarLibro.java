package controller;

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
@WebServlet(name = "BorrarLibro", urlPatterns = {"/BorrarLibro"})
public class BorrarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try
		{
			//SUSTITUYE AL JSP InstertarLibro
			System.out.println("BORRAR SERVLET");
			String isbn= request.getParameter("isbn");
			System.out.println(isbn);
			Libro libro= new Libro();
			libro.setIsbn(Integer.parseInt(isbn));
			libro.borrar();
			System.out.println("BE4 REQUEST DISPATCHER");
			request.getRequestDispatcher("MostrarLibro.jsp").forward(request, response);
			
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
