package dao.servicios;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import entidades.Categoria;
import entidades.Libro;
import interfaces.LibroDAO;
import interfaces.ServicioLibros;

public class ServicioLibrosImpl implements ServicioLibros
{
	private LibroDAO libroDAO=null;
	
	public ServicioLibrosImpl() 
	{
		
	}
	
	@Override
	public LibroDAO getLibroDAO() 
	{
	return libroDAO;
	}
	
	@Override
	public void setLibroDAO(LibroDAO libroDAO) 
	{
	this.libroDAO = libroDAO;
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
	public List<Libro> filtrarLibros(Set<String> setDeFiltros, HttpServletRequest request) 
	{
	//return libroDAO.filtrarLibros(setDeFiltros, request);
		return null;
	}
	@Override
	public void insertarLibro(Libro libro) {
		libroDAO.insertar(libro);
		
	}
	@Override
	public List<Libro> buscarLibrosPorCategoria(Categoria categoria) 
	{
	return libroDAO.buscarPorCategoria(categoria);
	}
	


	

}
