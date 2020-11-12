package dao.Hibernate;

import java.util.List;


import abstractas.GenericDAOJPAImpl;
import entidades.Categoria;
import entidades.Libro;
import interfaces.LibroDAO;

public class LibroDAOHibernateImpl extends GenericDAOJPAImpl<Libro, Integer> implements LibroDAO 
{
	

	/*
	public List<Libro> buscarTodos() 
	{
		
		TypedQuery<Libro> consulta = getManager().createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria",Libro.class);
		return consulta.getResultList();

	}
	@Override
	public List<Libro> filtrarLibros(Set<String> paramNames, HttpServletRequest request)
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		String query = "SELECT l FROM Libro l JOIN FETCH ";
		for (String name : paramNames) 
		{
			try 
			{    
	            query = query+"l."+name.substring(4)+"="+Integer.parseInt(request.getParameter(name));
		    }
			catch(NumberFormatException ex)
			{
				
			}
		 
		}
		TypedQuery<Libro> consulta = manager.createQuery(query, Libro.class);
		consulta.setParameter(1, categoria);
		TypedQuery<Libro> consulta = manager.createQuery(
				"SELECT l FROM Libro l WHERE l.categoria=?1", Libro.class);
		consulta.setParameter(1, categoria);
		List<Libro> listaDeLibros = consulta.getResultList();
		manager.close();
		return listaDeLibros;
		
	}
*/
	@Override
	public List<Libro> buscarPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}