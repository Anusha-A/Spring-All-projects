package comm.example.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.model.Todo;

public class ToDoFactory {
	private static SessionFactory factory;
	public static SessionFactory getSessionFactory()
	{
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Todo.class).buildSessionFactory();
		return factory;
	}
}
