package controlador.acciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import abstractas.DAOAbstractFactory;
import entidades.*;
import interfaces.DAOFactory;
import interfaces.LibroDAO;
import sevlets.excepciones.DBException;
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
		DAOFactory factoria = DAOAbstractFactory.getInstance("JPA");

		try
		{
			 out = response.getWriter();
			 
			int isbn = Integer.parseInt( request.getParameter("isbn"));
			String titulo = request.getParameter("titulo");
			LibroDAO libroDAO = factoria.getLibroDAO();
			libroDAO.insertar(new Libro(isbn,titulo,
											new Autor(Integer.parseInt(request.getParameter("autor"))),
											new Categoria(Integer.parseInt(request.getParameter("categoria")))));
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
