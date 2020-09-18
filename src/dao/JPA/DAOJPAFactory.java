package dao.JPA;

import interfaces.AutorDAO;
import interfaces.CategoriaDAO;
import interfaces.DAOFactory;
import interfaces.LibroDAO;

public class DAOJPAFactory implements DAOFactory {

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		 return new CategoriaDAOJPAImpl();
	}

	@Override
	public LibroDAO getLibroDAO() {
		// TODO Auto-generated method stub
		return new LibroDAOJPAImpl();
	}

	@Override
	public AutorDAO getAutorDAO() {
		// TODO Auto-generated method stub
		return new AutorDAOJPAImpl();
	}

}
