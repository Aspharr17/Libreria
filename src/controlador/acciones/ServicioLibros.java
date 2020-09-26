package controlador.acciones;

import java.util.List;

import entidades.Categoria;
import entidades.Libro;

public interface ServicioLibros {
	
	public void salvarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public List<Libro> buscarTodosLosLibros();
	public Libro buscarLibroPorClave(int isbn);
	public List<Libro> buscarLibrosPorCategoria(Categoria categoria);
	public void insertarLibro(Libro libro);

}
