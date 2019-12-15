package com.mycompany.hibernate_one_to_one.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_one_to_one.entity.Instructor;
import com.mycompany.hibernate_one_to_one.entity.InstructorDetails;

public class MyHibernatefactory {
	
		private static SessionFactory factory;
			
			public static SessionFactory getMySession()
			{
				factory=new Configuration().
						configure("hibernate.cfg.xml").
						addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
						.buildSessionFactory();
				return factory;
						
			}
		

}
