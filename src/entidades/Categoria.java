package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	private int id_cat;
	private String des_cat;
	@OneToMany
	@JoinColumn(name = "idCat_lib")
	private List<Libro> listaDeLibros;
	
	
	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
		}
		public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
		}
	
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getDes_cat() {
		return des_cat;
	}
	public void setDes_cat(String des_cat) {
		this.des_cat = des_cat;
	}
	public Categoria(int id_cat, String des_cat) {
		super();
		this.id_cat = id_cat;
		this.des_cat = des_cat;
	}
	public Categoria(int id_cat) {
		super();
		this.id_cat = id_cat;
	}
	public Categoria() {
		super();
	}

	

}
