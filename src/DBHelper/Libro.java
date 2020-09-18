package DBHelper;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@Entity
@Table(name="Libros")
public class Libro {
	@Id
	private int isbn;
	private String titulo;
	private String categoria;
	
	@Override
	public int hashCode()
	{
		Integer isbn = new Integer(this.isbn);
		return isbn.hashCode();
	}
	@Override
	public boolean equals(Object o)
	{
		int isbnLibro = ((Libro)o).getIsbn();
		if(isbnLibro == isbn)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public Libro(int isbn) {
		super();
		this.isbn = isbn;
	}
	public Libro(int isbn, String titulo, String categoria) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}
	
	public Libro() {
		super();
	}
	
	public void insertar () throws ClassNotFoundException, SQLException
	{
		System.out.println("Insertar");
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Libro> buscarTodos() 
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		String consulta = "from Libro libro";
		List<Libro> listaDeLibros = session.createQuery(consulta).list();
		session.close();
		return listaDeLibros;
	}
	@SuppressWarnings("unchecked")
	public List<Libro> buscarTodasLasCategorias() 
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		String consulta = "select distinct libro.categoria from Libro libro";
		List<Libro> listaDeCategorias = session.createQuery(consulta).list();
		session.close();
		return listaDeCategorias;
	}
	public void borrar() throws ClassNotFoundException, SQLException 
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
		}
	public static Libro buscarPorClave(int isbn)
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = (Libro) session.get(Libro.class, isbn);
		session.close();
		return libro;
	}
	public void guardar() throws ClassNotFoundException, SQLException
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarPorCategoria(String categoria)
	{
		SessionFactory factoria = new Configuration().configure().buildSessionFactory();
		Session session = factoria.openSession();
		String consulta = "from Libro libro where libro.categoria = '"+categoria+"'";
		List<Libro> listaDeLibros = session.createQuery(consulta).list();
		return listaDeLibros;
		
	}
}
