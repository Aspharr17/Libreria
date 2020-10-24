package interfaces;

import java.util.List;

import entidades.Autor;

public interface ServicioAutores 
{
	public List<Autor> buscarAutoresLibros();
	
	public AutorDAO getAutorDAO();
	public void setAutorDAO (AutorDAO autorDAO);

}
