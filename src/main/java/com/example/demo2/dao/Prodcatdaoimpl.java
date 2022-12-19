package com.example.demo2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo2.entity.ProdCategory;
import com.example.demo2.entity.Product;

@Repository
public class Prodcatdaoimpl implements Prodcatdao{

	@Autowired
	private EntityManager entityManager;
	@Override
	@Transactional
	public List<ProdCategory> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		List<ProdCategory> prodCats = currentSession.createQuery("from ProdCategory").getResultList();
		return prodCats;
	}
	@Override
	@Transactional
	public ProdCategory getcategorybyname(String prodcat) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query= currentSession.createQuery("from ProdCategory where category = :categoryname ");
		query.setParameter("categoryname",prodcat);
		ProdCategory productcategory = (ProdCategory) query.getSingleResult();
		
		return productcategory;
	}
	@Override
	@Transactional
	public void save(ProdCategory prodcat) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(prodcat);
	}
	@Override
	@Transactional
	public void deletebyid(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query= currentSession.createQuery("from ProdCategory where prodcatid = :catid ");
		query.setParameter("catid",id);
		ProdCategory prodcat = (ProdCategory) query.getSingleResult();
		currentSession.delete(prodcat);
	}
	
}
