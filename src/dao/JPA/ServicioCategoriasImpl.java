package dao.JPA;

import java.util.List;

import abstractas.DAOAbstractFactory;
import controlador.acciones.ServicioCategorias;
import entidades.Categoria;
import interfaces.CategoriaDAO;
import interfaces.DAOFactory;

public class ServicioCategoriasImpl implements ServicioCategorias {

	private CategoriaDAO categoriaDAO=null;
	
	public ServicioCategoriasImpl() 
	{
		DAOFactory factoria= DAOAbstractFactory.getInstance("JPA");
		categoriaDAO=factoria.getCategoriaDAO();
		
	}
	@Override
	public List<Categoria> buscarCategoriasLibros() {
		return categoriaDAO.buscarTodos();

	}

	@Override
	public Categoria buscarCategoriaPorClave(int id) {
		// TODO Auto-generated method stub
		return categoriaDAO.buscarPorClave(id);	}

}
