package com.mycompany.hibernate_manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_manytomany.model.Course;
import com.mycompany.hibernate_manytomany.model.Instructor;
import com.mycompany.hibernate_manytomany.model.InstructorDetail;
import com.mycompany.hibernate_manytomany.model.Review;
import com.mycompany.hibernate_manytomany.model.Student;

public class GetCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int studentId = 1;
			Student tempStudent = session.get(Student.class, studentId);

			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
		}

	}

}
