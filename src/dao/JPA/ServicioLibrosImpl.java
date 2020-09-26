package dao.JPA;

import java.util.List;

import abstractas.DAOAbstractFactory;
import controlador.acciones.ServicioLibros;
import entidades.Categoria;
import entidades.Libro;
import interfaces.DAOFactory;
import interfaces.LibroDAO;

public class ServicioLibrosImpl implements ServicioLibros
{
	private LibroDAO libroDAO=null;
	
	public ServicioLibrosImpl() {
	DAOFactory factoria= DAOAbstractFactory.getInstance("JPA");
	libroDAO= factoria.getLibroDAO();
	
	}
	
	@Override
	public void salvarLibro(Libro libro)
	{
	libroDAO.guardar(libro);
	}
	@Override
	public void borrarLibro(Libro libro) 
	{
	libroDAO.borrar(libro);
	}
	@Override
	public List<Libro> buscarTodosLosLibros() 
	{
	return libroDAO.buscarTodos();
	}
	@Override
	public Libro buscarLibroPorClave(int isbn) 
	{
	return libroDAO.buscarPorClave(isbn);
	}
	@Override
	public List<Libro> buscarLibrosPorCategoria(Categoria categoria) 
	{
	return libroDAO.buscarPorCategoria(categoria);
	}
	@Override
	public void insertarLibro(Libro libro) {
		libroDAO.insertar(libro);
		
	}
	

}
