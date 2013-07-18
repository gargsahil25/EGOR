package com.egor.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Projections;
//import org.hibernate.criterion.Restrictions;

import com.egor.model.LoginDetails;

public class LoginDAO {
	
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<LoginDetails> loginByUsernameAndPassword(String username, String password) {
		// Debugging
		System.out.println("LoginDAO.loginByUsernameAndPassword called with username: " + username + 
				" and password: " + password);
		
		String hql = "FROM LoginDetails WHERE username = :username AND password = :password";
		Query query = getSessionFactory().openSession().createQuery(hql);
		//query.setMaxResults(1);
		//query.setFirstResult(0);

		query.setString("username", username);
		query.setString("password", password);
		
//		Criteria criteria = getSessionFactory().openSession().createCriteria(LoginDetails.class);
//		criteria.add(Restrictions.eq("username", username));
//		criteria.setProjection(Projections.count("userId"));
//		criteria.addOrder(Order.desc("userId"));
//		criteria.list();
		
		System.out.println("Query: " + query.getQueryString());
		
		return (List<LoginDetails>) query.list();	
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
