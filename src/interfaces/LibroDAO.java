package interfaces;

import java.util.List;

import entidades.Categoria;
import entidades.Libro;

public interface LibroDAO extends GenericDAO<Libro, Integer>
{
		

	public abstract List<Libro> buscarPorCategoria(Categoria categoria);
}
