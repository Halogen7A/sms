package jpa.service;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.AbstractDAO;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService extends AbstractDAO implements CourseDAO{
	
	SessionFactory factory = super.getFactory();
	Session session = super.getSession();
	
	/*
	 * This method gets all available courses in the course table
	 * via the named query defined in the course POJO class.
	 */
	public List<Course> getAllCourses() {
		
		Query query = session.getNamedQuery("GetAllCourses");
		List<Course> courses = query.getResultList();
		
		return courses;
	}
	
	

}
