package interfaces;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import entidades.Libro;

public interface LibroDAO extends GenericDAO<Libro, Integer>
{
	public abstract List<Libro> filtrarLibros(Set<String> setDeFiltros, HttpServletRequest request );
}
