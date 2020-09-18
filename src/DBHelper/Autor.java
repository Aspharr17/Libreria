package DBHelper;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="Autores")
public class Autor {
	
	@Id
	private int id_aut;
	private String nom_aut;
	@OneToMany
	@JoinColumn(name="idAut_lib")
	private List<Autor> listaDeAutores;
	
	
	public List<Autor> getListaDeAutores() {
		return listaDeAutores;
	}

	public void setListaDeAutores(List<Autor> listaDeAutores) {
		this.listaDeAutores = listaDeAutores;
	}

	public int getId_aut() {
		return id_aut;
	}

	public void setId_aut(int id_aut) {
		this.id_aut = id_aut;
	}

	public String getNom_aut() {
		return nom_aut;
	}

	public Autor(int id_aut) {
		super();
		this.id_aut = id_aut;
	}

	public void setNom_aut(String nom_aut) {
		this.nom_aut = nom_aut;
	}


	public Autor() {
		// TODO Auto-generated constructor stub
	}
	
	public Autor(int id_aut, String nom_aut) {
		super();
		this.id_aut = id_aut;
		this.nom_aut = nom_aut;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Autor> buscarTodos() 
	{
		SessionFactory factoriaSession = new Configuration().configure().buildSessionFactory();
		Session session = factoriaSession.openSession();
		List<Autor> listaDeAutores = session.createQuery("from Autor autor").list();
		session.close();
		return listaDeAutores;
	}
}
