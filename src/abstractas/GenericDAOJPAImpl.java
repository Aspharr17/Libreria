package abstractas;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import interfaces.GenericDAO;


public abstract class GenericDAOJPAImpl<T, Id extends Serializable>  implements GenericDAO<T, Id> {
	
	private Class<T> claseDePersistencia;
	private EntityManagerFactory entityManagerFactory;


	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl() {
		this.claseDePersistencia = (Class<T>) ( (ParameterizedType)  getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	@Override
	public T buscarPorClave(Id id) {

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		
		T objeto = null;
		try {
			objeto = (T) manager.find(claseDePersistencia, id);
			return objeto;
		} finally {
			manager.close();
		}
	}

	@Override
	public List<T> buscarTodos() {

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		
		List<T> listaDeObjetos = null;
		try {
			TypedQuery<T> consulta = manager.createQuery("select o from " 
			+ claseDePersistencia.getSimpleName()+ " o ", claseDePersistencia);

			listaDeObjetos = consulta.getResultList();
			return listaDeObjetos;
		} finally {
			manager.close();
		}
	}
	@Override
	public void insertar(T objeto) {

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(objeto);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}
	@Override
	public void guardar(T objeto) {

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(objeto);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}
	@Override
	public void borrar(T objeto) {

		EntityManager manager = getEntityManagerFactory().createEntityManager();

		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(objeto));
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}
	
	/*
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl() 
	{
		this.claseDePersistencia = (Class<T>) ((ParameterizedType)getClass()
		.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T buscarPorClave(Id id) 
	{
		return getJpaTemplate().find(claseDePersistencia, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() 
	{
		return getJpaTemplate().find("select o from "
		+ claseDePersistencia.getSimpleName() + " o");
	}
	public void borrar(T objeto) 
	{
		getJpaTemplate().remove(getJpaTemplate().merge(objeto));
	}
	public void guardar(T objeto) 
	{
		getJpaTemplate().merge(objeto);
	}
	public void insertar(T objeto) 
	{
		getJpaTemplate().persist(objeto);
	}*/
	
	
}