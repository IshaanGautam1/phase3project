package com.example.demo2.dao;

import java.util.List;

import com.example.demo2.entity.Product;

public interface ProdDAO {

	public List<Product> getAllProducts();
	public void saveProduct(Product theProduct);
	public Product getById(int id);
	public void delete(Product theProduct);
}
