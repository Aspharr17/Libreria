package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Libro;

public class PruebaJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebaJPA pr = new PruebaJPA();
		pr.select();
		pr.insert();
		

	}
	private void select()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE_M1");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("Select l from Libro l", Libro.class);//Libro se refiere a la clase Java
		List<Libro> lista = consulta.getResultList();
		for(Libro l: lista)
		{
			System.out.println(l.getTit_lib());
		}
	}
	private void insert()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE_M1");
		EntityManager manager = emf.createEntityManager();
		Libro libro = new Libro();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.merge(libro);
		tx.commit();
		manager.close();
		
	}
}
