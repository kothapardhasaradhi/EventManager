package eventmgr.domain;

import java.util.List;


import hibernate.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocationTest {
	
	//private static SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	public static void saveLocations(){
		Session session = HibernateUtil.openSession();
		Location loc = new Location();
		loc.setName("vizag");
		loc.setAddress("jagadamba");
		
		System.out.println("saving location...");
		
		Transaction tx = session.beginTransaction();
		session.save(loc);
		tx.commit();
		session.close();
		
		
	}
	public static void testRetrive(){
		Session session = HibernateUtil.openSession();
		Query query= session.createQuery("from Location");
		Transaction tx =session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List list =query.list();
		for(Object loc :list) System.out.println(loc);
		tx.commit();
		session.close();
		
	}
	public static void testUpdate(String name,String address){
	
		System.out.println("updating...");
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Query query= session.createQuery("from Location where name=:name");
		query.setParameter("name", name);
		@SuppressWarnings("rawtypes")
		List list=query.list();
		if(list.size()==0)
			System.out.println("there is no Location with"+name);
		else{
			Location loc = (Location) list.get(0);
			loc.setAddress(address);
			//System.out.println(loc);
		}
		tx.commit();
		session.close();
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LocationTest t = new LocationTest();
		//saveLocations();
		//testRetrive();
		//testUpdate( "vizag","rthfkdjyg");
		//testRetrive();
		

	}

}
