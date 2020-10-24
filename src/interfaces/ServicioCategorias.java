package interfaces;

import java.util.List;

import entidades.Categoria;

public interface ServicioCategorias 
{
	
	public List<Categoria> buscarCategoriasLibros();
	public Categoria buscarCategoriaPorClave(int id);

	public CategoriaDAO getCategoriaDAO();
	public void setCategoriaDAO (CategoriaDAO categoriaDAO);

}
