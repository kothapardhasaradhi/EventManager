package hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static{
		try{
		Configuration config =new Configuration();
	    sessionFactory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Throwable e)
		{
			System.out.println("cant create session factory"+e);
			throw new ExceptionInInitializerError();
		}
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	public static Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	public static Session openSession()
	{
		return sessionFactory.openSession();
	}

}
