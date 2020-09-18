package dao.Hibernate;

import interfaces.AutorDAO;
import interfaces.CategoriaDAO;
import interfaces.DAOFactory;
import interfaces.LibroDAO;

public class DAOHibernateFactory implements DAOFactory{

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new CategoriaDAOHibernateImpl();
	}

	@Override
	public LibroDAO getLibroDAO() {
		// TODO Auto-generated method stub
		return new LibroDAOHibernateImpl();
	}

	@Override
	public AutorDAO getAutorDAO() {
		// TODO Auto-generated method stub
		return new AutorDAOHibernateImpl();
	}

}
