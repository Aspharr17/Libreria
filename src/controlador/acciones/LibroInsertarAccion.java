package controlador.acciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.*;
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
			libro.insertar();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
