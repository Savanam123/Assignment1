package com.jocata.customer.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.customer.model.CustomerDetails;


@Repository
public class HibernateUtils {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		Session session=null;
		try {
			session=sessionFactory.openSession();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return session;
	}
	private void closeSession(Session currentSession)
	{
		if(currentSession!=null)
		{
			currentSession.close();
		}
	}
	public <T> Serializable save(T entity)
	{
		Session currentSession=getSession();
		Serializable newPKID=null;
		try {
			currentSession.beginTransaction();
			newPKID=currentSession.save(entity);
			currentSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			closeSession(currentSession);
		}
		return newPKID;
	}
	public <T> void update(T entity)
	{
		Session currentSession=getSession();
		try {
			currentSession.beginTransaction();
			currentSession.update(entity);
			currentSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			closeSession(currentSession);
		}
	}
	public <T> void delete(T entity)
	{
		Session currentSession=getSession();
		try {
			currentSession.beginTransaction();
			currentSession.delete(entity);
			currentSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			closeSession(currentSession);
		}
	}
	@SuppressWarnings("unchecked")
	public <T> void deleteByHql(String hql)
	{
		Session currentSession=getSession();
		try {
			currentSession.beginTransaction();
			Query<T> query=currentSession.createQuery(hql);
			query.executeUpdate();
			currentSession.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			closeSession(currentSession);
		}
	}
    @SuppressWarnings("unchecked")
	public <T> List<T> loadEntityByHql(String hql)
    {
    	Session currentSession=getSession();
    	try {
    		Query<T> query=currentSession.createQuery(hql);
    		return query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			closeSession(currentSession);
		}
    	return null;
    }
    
    public CustomerDetails getById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		CustomerDetails employeeObj = currentSession.get(CustomerDetails.class, id);
		return employeeObj;
	}
}
