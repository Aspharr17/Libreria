package interfaces;

public interface DAOFactory {
	public CategoriaDAO getCategoriaDAO();
	public LibroDAO getLibroDAO();
	public AutorDAO getAutorDAO();

}
