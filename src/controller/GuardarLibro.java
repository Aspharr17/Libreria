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
 * Servlet implementation class GuardarLibro
 */
@WebServlet(name = "GuardarLibro", urlPatterns = {"/GuardarLibro"})
public class GuardarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try
		{
			int isbn = Integer.parseInt(request.getParameter("isbn"));
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			Libro libro = new Libro(isbn, titulo, categoria);
			libro.guardar();	
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
