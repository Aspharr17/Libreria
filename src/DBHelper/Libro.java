package DBHelper;

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
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}
	
	public Libro() {
		super();
	}
	
	public void insertar () 
	{
		String consultaSQL = "insert into Libros(isbn,titulo,categoria) values";
		consultaSQL += "("+isbn+", '"+titulo+"', '"+categoria+"')";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
	}

	public static List<Libro> buscarTodos() 
	{
		String consultaSQL = "select isbn,titulo,categoria from Libros";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL,
		Libro.class);
		return listaDeLibros;
	}
	public static List<String> buscarTodasLasCategorias() 
	{
		String consultaSQL = "select distinct(categoria) as categoria from Libros";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String>listaDeCategorias = helper.seleccionarRegistros(consultaSQL,
		String.class);
		return listaDeCategorias;
	}
	public void borrar() {
		String consultaSQL = "delete from Libros where isbn="+ this.isbn;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
		}
	public static Libro buscarPorClave(String isbn)
	{
		String consultaSQL = "select isbn, titulo, categoria FROM libros WHERE isbn="+isbn;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);

		return listaDeLibros.get(0);
	}
	public void guardar() 
	{
		String consultaSQL = "UPDATE libros SET titulo= '"+ titulo+"', categoria= '"+categoria+
							"' WHERE isbn="+isbn;
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static List<Libro> buscarPorCategoria(String categoria)
	{
		String consultaSQL = "SELECT isbn,titulo,categoria FROM libros WHERE categoria='"+categoria+"'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
		return listaDeLibros;
		
	}
}
