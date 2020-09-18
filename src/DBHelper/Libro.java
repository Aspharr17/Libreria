package DBHelper;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@Entity
@Table(name="Libros")
public class Libro {
	@Id
	private int cve_lib;
	private String tit_lib;
	@ManyToOne
	@JoinColumn (name="idCat_lib")
	private Categoria categoria;
	//private int idCat_lib;
	
	@ManyToOne
	@JoinColumn(name="idAut_lib")
	private Autor autor;

	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public int getCve_lib() {
		return cve_lib;
	}

	public void setCve_lib(int cve_lib) {
		this.cve_lib = cve_lib;
	}

	public String getTit_lib() {
		return tit_lib;
	}

	public void setTit_lib(String tit_lib) {
		this.tit_lib = tit_lib;
	}
	/*
	public int getIdCat_lib() {
		return idCat_lib;
	}

	public void setIdCat_lib(int idCat_lib) {
		this.idCat_lib = idCat_lib;
	}

	public String getAut_lib() {
		return aut_lib;
	}


	public void setAut_lib(String aut_lib) {
		this.idaut_lib = aut_lib;
	}
/*
	public Libro(int cve_lib, String tit_lib, int idCat_lib, String aut_lib) {
		super();
		this.cve_lib = cve_lib;
		this.tit_lib = tit_lib;
		this.idCat_lib = idCat_lib;
		this.aut_lib = aut_lib;
	}

	public Libro(int cve_lib, String tit_lib, String aut_lib, Categoria categoria) {
		super();
		this.cve_lib = cve_lib;
		this.tit_lib = tit_lib;
		this.aut_lib = aut_lib;
		this.categoria = categoria;
	}
	
*/
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Libro(int cve_lib, String tit_lib, Autor autor, Categoria categoria) {
		super();
		this.cve_lib = cve_lib;
		this.tit_lib = tit_lib;
		this.autor = autor;
		this.categoria = categoria;
	}

	public void insertar () throws ClassNotFoundException, SQLException
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager= factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try
		{
		tx = manager.getTransaction();
		tx.begin();
		manager.persist(this);
		tx.commit();
		}
		catch(PersistenceException e)
		{
			manager.getTransaction().rollback();
			throw e;
		}
		finally
		{
		manager.close();
		}
	}

	public List<Libro> buscarTodos() 
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria",Libro.class);
		List<Libro> listaDeLibros = null;
		try
		{
			listaDeLibros = consulta.getResultList();
		}
		catch(PersistenceException e)
		{
			throw e;
			
		}
		finally
		{
			manager.close();

		}
		return listaDeLibros;
	}

	public void borrar() throws ClassNotFoundException, SQLException 
	{

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager= factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try
		{
			tx =manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(this)); //Borra en memoria y bd
			tx.commit();
		}
		catch(PersistenceException e)
		{
			manager.getTransaction().rollback();
			throw e;
		}
		finally
		{
			manager.close();
		}
		
	}
	public static Libro buscarPorClave(int cve_lib)
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery(
				"SELECT l from Libro l JOIN FETCH l.categoria Where l.cve_lib=?1", Libro.class);
		consulta.setParameter(1, cve_lib);
		Libro libro = consulta.getSingleResult();
		manager.close();
		return libro;
		
	}
	public void guardar() throws ClassNotFoundException, SQLException
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try
		{
		tx = manager.getTransaction();
		tx.begin();
		manager.merge(this);
		tx.commit();
		}
		catch(PersistenceException e)
		{
			manager.getTransaction().rollback();
			throw e;
		}
		finally
		{
		manager.close();
		}
	}
	
	public static List<Libro> buscarPorCategoria(Categoria categoria)
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
