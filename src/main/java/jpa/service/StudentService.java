package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.AbstractDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends AbstractDAO implements StudentDAO {
	
	SessionFactory factory = super.getFactory();
	Session session = super.getSession();

	/*
	 * This method gets all available students in the student table
	 * via the named query defined in the student POJO class.
	 */
	public List<Student> getAllStudents() {
		
		Query query = session.getNamedQuery("GetAllStudents");
		List<Student> students = query.getResultList();
		
		
		return students;
	}

	/*
	 * This method takes in an email and gets the student with the matching email 
	 * and returns the student.
	 */
	public Student getStudentByEmail(String sEmail) {
		
		Query query = session.getNamedQuery("GetStudentByEmail");
		query.setParameter("sEmail", sEmail);
		Student student = (Student) query.getSingleResult();
		
		return student;
	}

	/*
	 * This method takes in an email and a password 
	 * and gets the student with the matching email and password
	 * and returns a boolean value on whether there is a matching student in the student table.
	 */
	public boolean validateStudent(String sEmail, String sPassword) {
		
		TypedQuery query = session.getNamedQuery("GetStudentByEmailAndPassword");
		query.setParameter("sEmail", sEmail);
		query.setParameter("sPassword", sPassword);
		List<Student> students = query.getResultList();
		
		
		if(students.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * This method takes in an email and a course id, validates the student,
	 * and, through finding the course with the given id,
	 * adds the course to the student's course list, thus
	 * registering the student to the course.
	 */

	public void registerStudentToCourse(String sEmail, int cId) {
		
		Transaction t = session.beginTransaction();
		
		Query query = session.getNamedQuery("GetStudentByEmail");
		query.setParameter("sEmail", sEmail);
		Student student = (Student) query.getSingleResult();
		
		String sPassword = student.getsPassword();
		
		if(validateStudent(sEmail, sPassword)) {
			List<Course> courses = student.getsCourses();
			List<Integer> idList = new ArrayList<Integer>();
			
			for(Course course : courses) {
				idList.add(course.getcId());
			}
			
			if(!idList.contains((Integer)cId)) {
				Query query2 = session.getNamedQuery("GetCourseById");
				query2.setParameter("cId", cId);
				Course course = (Course) query2.getSingleResult();
				student.getsCourses().add(course);
				session.update(student);
				t.commit();
			}
			
			else {
				System.out.println("The student is already registered to this course!");
			}
		}
		
		else {
			System.out.println("The student is not valid!");
		}
		
		
	}

	/*
	 * This method takes in an email and gets the student with the matching email 
	 * and returns the student's course list.
	 */
	public List<Course> getStudentCourses(String sEmail) {
		Student student = getStudentByEmail(sEmail);
		return student.getsCourses();
	}

}
