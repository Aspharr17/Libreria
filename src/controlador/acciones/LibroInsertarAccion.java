package controlador.acciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.*;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
/**
 * Servlet implementation class LibroInsertar
 */
public class LibroInsertarAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//Setea la salida como html
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try
		{
			 out = response.getWriter();

			//SUSTITUYE AL JSP InstertarLibro
			int isbn = Integer.parseInt( request.getParameter("isbn"));
			String titulo = request.getParameter("titulo");
			Categoria categoria = new Categoria(Integer.parseInt(request.getParameter("categoria")));
			Autor autor = new Autor(Integer.parseInt(request.getParameter("autor")));

			Libro libro = new Libro(isbn, titulo, autor, categoria);
			LibroDAO libroDAO = new LibroDAOJPAImpl();
			libroDAO.insertar(libro);
			//MUESTRA PAGINA DE OPCIONES PARA SEGUIR INSERTANDO O MOSTRAR LOS LIBROS
			String page = "<html>"
						+ "<head>"
						+ "<title>Registro realizado</title>"
						+ "</head>"
						+ "<h1> Se registró el libro "+titulo+" correctamente</h1>"
						+ "<a href=\"FormularioInsertarLibro.jsp\">Insertar Libro</a>"
						+ "<br/>"
						+ "<a href= MostrarLibro.do>MostrarLibro </a>"
						+ "</body>"
						+ "</html>";
			out.println(page);
			
			
		}catch(DBException e)
		{
			out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}

		return null;
	}

}
