package com.mycompany.hibernate_one_to_one;

import static java.lang.System.in;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate_one_to_one.entity.Instructor;
import com.mycompany.hibernate_one_to_one.entity.InstructorDetails;
import com.mycompany.hibernate_one_to_one.factory.MyHibernatefactory;



/**
 * Hello world!
 *
 */
public class App 
{
	
	private static Scanner scanner = new Scanner(in);
	
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = MyHibernatefactory.getMySession();
		Session session = null;
		
		
		
		session = sessionFactory.getCurrentSession();
    	try {
    		
    		
    		
    		session = sessionFactory.openSession();
    		Instructor i = new Instructor();    		
    		i.setFirstName("Sunny");
    		i.setLastName("Deol");
    		i.setEmail("sunny@i.com");

    		InstructorDetails id = new InstructorDetails();
    		id.setHobby("Cricket");
    		id.setYoutubeChannel("www.youtube.com");
    		
    		id.setInstructor(i);
    		int idd = i.getId();
			i.setInstructorDetail(id);
    		
    		session.getTransaction().begin();
    		session.save(id);
  			session.getTransaction().commit();	
  			System.out.println("sucess");
			session.close();
    		
    
    		
    		
    		
    		//session.getTransaction().begin();
    		////session.persist(i);
  			//session.getTransaction().commit();	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}

    }
}
