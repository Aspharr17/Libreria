package dao.servicios;

import java.util.List;

import entidades.Autor;
import interfaces.AutorDAO;
import interfaces.ServicioAutores;

public class ServicioAutoresImpl implements ServicioAutores {

	private AutorDAO autorDAO = null;
	public ServicioAutoresImpl() {

		}

	@Override
	public List<Autor> buscarAutoresLibros() {
		return autorDAO.buscarTodos();
	}

	@Override
	public AutorDAO getAutorDAO() {
		return autorDAO;
	}

	@Override
	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}

}
