package interfaces;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import entidades.Libro;

public interface ServicioLibros {
	
	public void salvarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public List<Libro> buscarTodosLosLibros();
	public Libro buscarLibroPorClave(int isbn);
	public List<Libro> filtrarLibros(Set<String> setDeFiltros, HttpServletRequest request);
	public void insertarLibro(Libro libro);
	
	public LibroDAO getLibroDAO();
	public void setLibroDAO(LibroDAO libro);
	
}
