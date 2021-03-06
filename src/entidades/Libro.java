package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="libros")
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
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(int cve_lib) {
		super();
		this.cve_lib = cve_lib;
	}
	
	
}
