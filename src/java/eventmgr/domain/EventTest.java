package eventmgr.domain;

import hibernate.util.HibernateUtil;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EventTest {
	
	//private static SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	
	@SuppressWarnings("deprecation")
	public static void saveEvents()
	{
		Event event =new Event();
		event.setName("Hjjh");
		event.setStartDate(new java.util.Date(108,Calendar.JULY,1));
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Query query= session.createQuery("from Location where name =:name");
		query.setParameter("name","vizag");
		@SuppressWarnings("rawtypes")
		List list =query.list();
		event.setLocation((Location)list.get(0));
		System.out.printf("Saving event: %s\nLocation: %s\n",event, event.getLocation() );
		session.save(event);
		tx.commit();
		
		
		
	}
        public static void testRetrieve(){
            Session session = HibernateUtil.openSession();
            Query query = session.createQuery("from Event");
            Transaction tx = session.beginTransaction();
            List list = query.list();
            tx.commit();
            session.close();
            if(list.size()==0)System.out.println("not found");
            else{
            for(Object obj:list) System.out.println(obj);}

            
        }
        public static void testUpdate(String name,Location loc){
            Session session = HibernateUtil.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Event where name=:name");
            query.setParameter("name",name);
            List list =query.list();
            if(list.size()==0) System.out.println("No record present with event name");
            else 
            {   Event event = (Event)list.get(0);
                //event=(Event)session.get(Event.class,event.getId());
                event.setLocation(loc);
                //session.saveOrUpdate(event);
            }
            tx.commit();
            session.close();
        }
        public static void addSpeaker(String eventName,Speaker speaker)
        {
            Session session = HibernateUtil.openSession();
            Transaction tx=session.beginTransaction();
            Query query =session.createQuery("from Event where name=:name");
            query.setParameter("name", eventName);
            List list = query.list();
            Event event =(Event)list.get(0);
            event.addSpeaker(speaker);
            tx.commit();
            session.close();
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LocationTest.saveLocations( );
		//saveEvents();
		testRetrieve();
               
                
             // updating location for event
//                Location location=new Location();
//               Session s=HibernateUtil.openSession();
//               Query query=s.createQuery("from Location where name=:address");
//               query.setParameter("address", "vizag");
//               List list=query.list();
//               if(list.size()==0)
//                   System.out.println("no locations");
//               else{
//                   location=(Location)list.get(0);
//                testUpdate("java days",location);
//               }
//               s.close();

//             adding speaker to event
//               Speaker speaker = new Speaker();
//                speaker.setName("Balaji");
//                speaker.setTelephone("9848033228");
//                addSpeaker("java days", speaker);
//                

	}

}
