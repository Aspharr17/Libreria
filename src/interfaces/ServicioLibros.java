package interfaces;

import java.util.List;

import entidades.Autor;
import entidades.Categoria;
import entidades.Libro;

public interface ServicioLibros {
	
	public void salvarLibro(Libro libro);
	public void borrarLibro(Libro libro);
	public List<Libro> buscarTodosLosLibros();
	public List<Categoria> buscarCategoriasLibros();
	public Libro buscarLibroPorClave(int isbn);
	public Categoria buscarCategoriaPorClave(int id);
	public List<Libro> buscarLibrosPorCategoria(int categoria);
	public List<Autor> buscarAutoresLibros();
	public void insertarLibro(Libro libro);

}
