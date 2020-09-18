package DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Libro {
		
	private int isbn;
	private String titulo;
	private String categoria;
	
	
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
	
	public Libro(int isbn, String titulo, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}
	
	public Libro() {
		super();
	}
	public static ResultSet buscarTodasLasCategorias() {
		String consultaSQL = "select distinct (categoria) from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		return rs;
	}
	public void insertar () {
		String consultaSQL = "insert into Libros(isbn,titulo,categoria) values";
		consultaSQL += "("+isbn+", '"+titulo+"', '"+categoria+"')";
		System.out.println(consultaSQL);
		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}
	public static List<Libro> buscarTodos () {
		
		String consultaSQL = "select isbn, titulo, categoria from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		List<Libro> listaDeLibros = new ArrayList<Libro>();
		try {
			while(rs.next()) {
				listaDeLibros.add(new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("categoria")));
				
			}
		}catch(SQLException e) {
			System.out.println("SQLException"+ e.getMessage());
		}
		return listaDeLibros;
	}
}
