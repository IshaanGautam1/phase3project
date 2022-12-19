package com.example.demo2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo2.entity.Product;

@Repository
public class ProdDAOimpl implements ProdDAO {

	@Autowired
	private EntityManager entityManager;
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		Session currentSession = entityManager.unwrap(Session.class);
		List<Product> products = currentSession.createQuery("from Product").getResultList();
		return products ;
	}
	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theProduct);
		
	}
	@Override
	@Transactional
	public Product getById(int id) {
		Product theProduct = new Product();
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from Product where productid= :prodid");
		query.setParameter("prodid", id);
		theProduct = (Product) query.getSingleResult();
		return theProduct;
	}
	@Override
	@Transactional
	public void delete(Product theProduct) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.delete(theProduct);	
	}

}
