package com.mycompany.hibernate_one_to_one.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate_one_to_one.factory.MyHibernatefactory;

public class GetInstructor {
	public static void main( String[] args )
    {
    	SessionFactory sessionFactory = MyHibernatefactory.getMySession();
		Session session = null;
		
		session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Found instructor: " + tempInstructor);

			if (tempInstructor != null) {

				System.out.println("Deleting: " + tempInstructor);

				session.delete(tempInstructor);
			}

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}
	
    }

}
