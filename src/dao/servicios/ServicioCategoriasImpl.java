package dao.servicios;

import java.util.List;

import entidades.Categoria;
import interfaces.CategoriaDAO;
import interfaces.ServicioCategorias;

public class ServicioCategoriasImpl implements ServicioCategorias {

	private CategoriaDAO categoriaDAO=null;

	public ServicioCategoriasImpl() 
	{

	}
	
	@Override
	public CategoriaDAO getCategoriaDAO() 
	{
	return categoriaDAO;
	}
	
	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) 
	{
	this.categoriaDAO = categoriaDAO;
	}
		@Override
	public List<Categoria> buscarCategoriasLibros() 
	{
		return categoriaDAO.buscarTodos();

	}

	@Override
	public Categoria buscarCategoriaPorClave(int id) 
	{
		return categoriaDAO.buscarPorClave(id);	
	}

}
