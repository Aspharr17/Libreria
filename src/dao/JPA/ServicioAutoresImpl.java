package dao.JPA;

import java.util.List;

import abstractas.DAOAbstractFactory;
import controlador.acciones.ServicioAutores;
import entidades.Autor;
import interfaces.AutorDAO;
import interfaces.DAOFactory;

public class ServicioAutoresImpl implements ServicioAutores {

	private AutorDAO autorDAO = null;
	public ServicioAutoresImpl() {
		DAOFactory factoria= DAOAbstractFactory.getInstance("JPA");
		autorDAO = factoria.getAutorDAO();
		
		}

	@Override
	public List<Autor> buscarAutoresLibros() {
		// TODO Auto-generated method stub
		return autorDAO.buscarTodos();
	}

}
