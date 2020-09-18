package abstractas;

import dao.Hibernate.DAOHibernateFactory;
import dao.JPA.DAOJPAFactory;
import interfaces.DAOFactory;

public abstract class DAOAbstractFactory 
{
	public static DAOFactory getInstance(String tipo) {
		
		
		if (tipo.equals("Hibernate")) {
			return new DAOHibernateFactory();
		} else {
			return new DAOJPAFactory();
		}
	}
}
