package dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import abstractas.GenericDAOJPAImpl;
import entidades.Categoria;
import entidades.Libro;
import interfaces.LibroDAO;
import sevlets.aplicacion.JPAHelper;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, Integer> implements LibroDAO {
	
	
	

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
/*
	private static final String QUERY = "SELECT l FROM Libro l JOIN FETCH l.categoria JOIN FETCH l.autor";
	{
		TypedQuery<Libro> consulta = getManager().createQuery(QUERY,Libro.class);
		return consulta.getResultList();

	}
	 
	@Override
	public List<Libro> filtrarLibros(Set<String> setDeFiltros, HttpServletRequest request)
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		String queryFiltro = QUERY+" WHERE";
	
		for (String filtro : setDeFiltros)
		{
			try 
			{   
				//Filtro tiene de nombre "sel_"+atributo. El parseInt es para verificar que fue seleccionada una opci�n.
				filtro = filtro.substring(4);
				queryFiltro = queryFiltro+" l."+filtro+"="+Integer.parseInt(request.getParameter("sel_"+filtro))+" AND";
		    }
			catch(NumberFormatException ex){
			}
		}
		queryFiltro = queryFiltro.substring(0,queryFiltro.length()-4);
		
		TypedQuery<Libro> consulta = manager.createQuery(queryFiltro,Libro.class);
		List<Libro> listaDeLibros = consulta.getResultList();
		manager.close();
		return listaDeLibros;

		/*TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l join fetch l.autor join fetch l.categoria WHERE l.categoria=?1", Libro.class);
		consulta.setParameter(1, categoria);
	}*/
	

}