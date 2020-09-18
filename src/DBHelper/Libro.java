package DBHelper;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
		String consulta = "from Libro libro right join fetch libro.categoria";
		List<Libro> listaDeLibros = session.createQuery(consulta).list();
		session.close();
		return listaDeLibros;
	}

	public void borrar() throws ClassNotFoundException, SQLException 
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
		}
	public static Libro buscarPorClave(int cve_lib)
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = (Libro) session.get(Libro.class, cve_lib);
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
