package dao.Hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import abstractas.GenericDAOJPAImpl;
import entidades.Categoria;
import entidades.Libro;
import interfaces.LibroDAO;
import sevlets.aplicacion.JPAHelper;

public class LibroDAOHibernateImpl extends GenericDAOJPAImpl<Libro, Integer> implements LibroDAO 
{
	

	
	public List<Libro> buscarTodos() 
	{
		
		TypedQuery<Libro> consulta = getManager().createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria",Libro.class);
		return consulta.getResultList();

	}
	@Override
	public List<Libro> buscarPorCategoria(Categoria categoria)
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery(
				"SELECT l FROM Libro l WHERE l.categoria=?1", Libro.class);
		consulta.setParameter(1, categoria);
		List<Libro> listaDeLibros = consulta.getResultList();
		manager.close();
		return listaDeLibros;
		
	}

}