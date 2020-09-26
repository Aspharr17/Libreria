package controlador.acciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abstractas.Accion;
import dao.JPA.ServicioLibrosImpl;
import entidades.Autor;
import entidades.Categoria;
import entidades.Libro;
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
		
		try
		{
			out = response.getWriter();
			 
			
			new ServicioLibrosImpl().insertarLibro(new Libro(Integer.parseInt(request.getParameter("isbn")),
					request.getParameter("titulo"),
					new Autor(Integer.parseInt(request.getParameter("autor"))),
					new Categoria(Integer.parseInt(request.getParameter("categoria"))))
					);
			
			
			//MUESTRA PAGINA DE OPCIONES PARA SEGUIR INSERTANDO O MOSTRAR LOS LIBROS
			String page = "<html>"
						+ "<head>"
						+ "<title>Registro realizado</title>"
						+ "</head>"
						+ "<h1> Se registró el libro "+request.getParameter("titulo")+" correctamente</h1>"
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
