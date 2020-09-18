package dao;

import java.util.List;

import DBHelper.Categoria;
import DBHelper.Libro;

public interface LibroDAO extends GenericDAO<Libro, Integer>
{
		

	public abstract List<Libro> buscarPorCategoria(Categoria categoria);
}
