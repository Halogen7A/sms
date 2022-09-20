package jpa.mainrunner;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;


public class App {
	public static void main(String[] args) {
		
		/*
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		Course chemistry = new Course();
		chemistry.setcInstructorName("Walter White");
		chemistry.setcName("Chemistry");
		
		
		Course physics = new Course();
		physics.setcInstructorName("Richard Feynman");
		physics.setcName("Physics");
		
		
		Course math = new Course();
		math.setcInstructorName("Eddie Woo");
		math.setcName("Math");
		
		
		Course english = new Course();
		english.setcInstructorName("John Keating");
		english.setcName("Enlgish");
		
		session.save(chemistry);
		session.save(physics);
		session.save(math);
		session.save(english);
		
		List<Course> c1 = new ArrayList<Course>();
		c1.add(english);
		
		List<Course> c2 = new ArrayList<Course>();
		c2.add(chemistry);
		c2.add(physics);
		
		
		List<Course> c3 = new ArrayList<Course>();
		c3.add(chemistry);
		c3.add(english);
		c3.add(math);
		c3.add(physics);
		
		Student s1 = new Student();
		s1.setsEmail("halitosmanozgur@hotmail.com");
		s1.setsName("Halit Osman Ozgur");
		s1.setsPassword("McQueen95");
		s1.setsCourses(c3);
		
		Student s2 = new Student();
		s2.setsEmail("alexander@gmail.com");
		s2.setsName("Alexander the Great");
		s2.setsPassword("alexandria356");
		s2.setsCourses(c1);
	
		Student s3 = new Student();
		s3.setsEmail("ben10@gmail.com");
		s3.setsName("Ben Tennyson");
		s3.setsPassword("gray10matter");
		s3.setsCourses(c2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		

		t.commit();
		session.close();
		factory.close();
		*/
		
		
		SMSRunner runner = new SMSRunner();
		runner.run();
	}
}
