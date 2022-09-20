package jpa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Creates a SessionFactory and Session that is used all across service methods.
 * @author halit
 *
 */
public abstract class AbstractDAO {
	
	
	
	private SessionFactory factory = new Configuration().configure().buildSessionFactory();
	private Session session = factory.openSession();
	
	
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	
	
}
