package test;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import DBHelper.Autor;
import DBHelper.Categoria;
import DBHelper.Libro;

public class Prueba1 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prueba1 p1 = new Prueba1();
		p1.insertarLibro();
		p1.select();
		int isbn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese isbn de libro"));
		p1.selectLibro(isbn);
		p1.delete(isbn);
		p1.select();
		p1.filtrado();
	}
	private void insertarLibro()
	{
		Session session = null;
		Transaction transaccion = null;
		try 
		{	
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaccion = session.beginTransaction();
			Categoria categoria = new Categoria();
			Autor autor = new Autor();
			Libro libro = new Libro(3,"java",autor, categoria);
			session.saveOrUpdate(libro);
			transaccion.commit();
		
		}catch(HibernateException e) 
		{
			
			System.out.println(e.getMessage());
		
		}finally {
			
			session.close();
			System.out.println("Realizado");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void select()
	{
		Session session = null;
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query consulta = session.createQuery("from Libro libro");
			List<Libro> lista = consulta.list();
			for(Libro l :lista) {
				System.out.println(l.getTit_lib());
				System.out.println(l.getCategoria().getDes_cat());
				}
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			
		}finally {
			session.close();
		}
			
	}
	@SuppressWarnings("unused")
	private void selectLibro(int isbn)
	{
		Session session = null;
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Libro libro = session.get(Libro.class, isbn);
			//System.out.println(libro.getIsbn());
			//System.out.println(libro.getTitulo());
			//System.out.println(libro.getCategoria());
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			
		}finally {
			session.close();
		}
	}
	private void delete(int isbn)
	{

		Session session = null;
		Transaction transaccion = null;
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaccion = session.beginTransaction();
			Libro libro = session.get(Libro.class, isbn);
			session.delete(libro);
			transaccion.commit();

		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			
		}finally {
			session.close();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void filtrado()
	{
		Session session = null;

		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query consulta = session.createQuery("select distinct libro.categoria from Libro libro");
			List<String> categorias = consulta.list();
			for(int i = 0; i<categorias.size(); i++)
			{
				System.out.println(categorias.get(i));
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese categoria: ");
			String categoria = sc.nextLine ();
			sc.close();
			consulta = session.createQuery("from Libro libro where libro.categoria = '"+categoria+"'");
			List<Libro> lista = consulta.list();
			for(Libro l: lista)
			{
				System.out.println(l.getCve_lib());
				//System.out.println(l.getTitulo());
				//System.out.println(l.getCategoria());
			}
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			
		}finally {
			session.close();
			System.out.println("Sesión cerrada");
		}
	}
	

}
