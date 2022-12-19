package com.example.demo2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo2.entity.Order;
import com.example.demo2.entity.User;
@Repository
public class UsersDAOimpl implements UsersDAO {

	@Autowired
	private EntityManager entityManager;
	@Override
	@Transactional
	public User findByusername(String username) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from User where username = :theusername");
		query.setParameter("theusername", username);
		User theUser= new User();
		theUser=(User) query.getSingleResult();
		return theUser;
	}

	@Override
	@Transactional
	public void addUsers(User theUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theUser);
	}

	@Override
	@Transactional
	public List<User> getall() {
		Session currentSession = entityManager.unwrap(Session.class);
		List<User> users = currentSession.createQuery("from User").getResultList();
		return users;
	}

}
