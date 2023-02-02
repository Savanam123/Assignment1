package com.jocata.customer.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.customer.entity.CustomerDetails;


@SuppressWarnings("deprecation")
@Repository
public class HibernateUtils {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return session;
	}
	private void closeSession(Session currentSession) {
		if(currentSession != null) currentSession.close();
	}
	
	public <T> Serializable save(T entity) {
		
		Session currentSession = getSession();
		Serializable newPkId = null;
		try {
			
			currentSession.beginTransaction();
			newPkId = currentSession.save(entity);
			currentSession.getTransaction().commit();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return newPkId;
	}
	
	public <T> void update(T entity) {
		Session currentSession = getSession();
		try {
			
			currentSession.beginTransaction();
			currentSession.update(entity);
			currentSession.getTransaction().commit();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
	}
	
//	public <T> void delete(T entity) {
//		Session currentSession = getSession();
//		try {
//			
//			currentSession.beginTransaction();
//			currentSession.delete(entity);
//			currentSession.getTransaction().commit();
//			
//		}catch(Exception exception) {
//			exception.printStackTrace();
//			closeSession(currentSession);
//		}
//	}
	
	public <T> void deleteByHql(String hql) {
		Session currentSession = getSession();
		try {
			
			currentSession.beginTransaction();
			@SuppressWarnings({ "rawtypes" })
			Query query = currentSession.createQuery(hql);
			query.executeUpdate();
			currentSession.getTransaction().commit();	
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
	}
	
	public <T> T getEntityById(Class<T> T, Serializable pkId) {
		Session currentSession = getSession();
		try {
			
			return currentSession.get(T, pkId);
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
	
	public <T> T getEntityByHql(String hql) {
		Session currentSession = getSession();
		try {
			
			@SuppressWarnings({ "unchecked" })
			Query<T> query = currentSession.createQuery(hql);
			List<T> myList = query.list();
			
			if(myList != null && myList.size() >0) 
				return myList.get(0);
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
	
	public <T> List<T> loadEntityByClassName(Class<T> T) {
		Session currentSession = getSession();
		try {
			
			@SuppressWarnings({ "unchecked" })
			Query<T> query = currentSession.createQuery("from " + T.getName());
			return query.list();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
	
	public <T> List<T> loadEntityByHql(String hql) {
		Session currentSession = getSession();
		try {
			
			@SuppressWarnings({ "unchecked" })
			Query<T> query = currentSession.createQuery(hql);
			return query.list();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
	public List<CustomerDetails> getAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<CustomerDetails> query = currentSession.createQuery("from CustomerDetails",CustomerDetails.class);
        List<CustomerDetails> list = query.getResultList();
        return list;
    }
	public CustomerDetails get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		CustomerDetails employeeObj = currentSession.get(CustomerDetails.class, id);
		return employeeObj;
	}
	public void deleteById(int id) {
        Session curreSession = entityManager.unwrap(Session.class);
        CustomerDetails employeeObj = curreSession.get(CustomerDetails.class, id);
        curreSession.delete(employeeObj);
        
    }
	
}
