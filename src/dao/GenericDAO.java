package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T,Id extends Serializable> {
	T buscarPorClave (Id id);
	List<T>buscarTodos();
	void insertar(T objeto);
	void guardar(T objeto);
	void borrar(T objeto);
}