package entidades;

import java.util.List;

import abstractas.DAOAbstractFactory;
import interfaces.AutorDAO;
import interfaces.CategoriaDAO;
import interfaces.DAOFactory;
import interfaces.LibroDAO;
import interfaces.ServicioLibros;

public class ServicioLibrosImpl implements ServicioLibros
{
	private LibroDAO libroDAO=null;
	private CategoriaDAO categoriaDAO=null;
	private AutorDAO autorDAO = null;
	
	public ServicioLibrosImpl() {
	DAOFactory factoria= DAOAbstractFactory.getInstance("JPA");
	libroDAO= factoria.getLibroDAO();
	categoriaDAO=factoria.getCategoriaDAO();
	autorDAO = factoria.getAutorDAO();
	
	}
	
	public void salvarLibro(Libro libro)
	{
	libroDAO.guardar(libro);
	}
	public void borrarLibro(Libro libro) 
	{
	libroDAO.borrar(libro);
	}
	public List<Libro> buscarTodosLosLibros() 
	{
	return libroDAO.buscarTodos();
	}
	public List<Categoria> buscarCategoriasLibros() 
	{
	return categoriaDAO.buscarTodos();
	}
	public Libro buscarLibroPorClave(int isbn) 
	{
	return libroDAO.buscarPorClave(isbn);
	}
	public Categoria buscarCategoriaPorClave(int id) 
	{
	return categoriaDAO.buscarPorClave(id);
	}
	public List<Libro> buscarLibrosPorCategoria(int id) 
	{
	Categoria categoria= categoriaDAO.buscarPorClave(id);
	return libroDAO.buscarPorCategoria(categoria);
	}

	@Override
	public List<Autor> buscarAutoresLibros() {
		return autorDAO.buscarTodos();
	}

	@Override
	public void insertarLibro(Libro libro) {
		libroDAO.insertar(libro);
		
	}

}
