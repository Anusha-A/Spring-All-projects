package com.mycompany.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    		try {
    			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Account.class)
    					.addAnnotatedClass(SavingAccount.class)
    					.addAnnotatedClass(CurrentAccount.class).buildSessionFactory();
    			Session session = factory.openSession();
    			Account acc = new Account("Kumar","34243626",50000,"Udupi");
    			SavingAccount savacc = new SavingAccount("Sushi","44373",67555,"Karkala",500);
    			CurrentAccount curracc = new CurrentAccount("Ram","5487343",60000,"Bangalore",new Date());
    			session.getTransaction().begin();
    			session.save(acc);
    			session.save(savacc);
    			session.save(curracc);
    			session.getTransaction().commit();
    			System.out.println("ok..");
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	
    }
}
