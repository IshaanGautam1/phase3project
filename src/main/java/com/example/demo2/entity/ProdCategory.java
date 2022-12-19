package com.example.demo2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="prod_category")
public class ProdCategory {
	@Override
	public String toString() {
		return "ProdCategory [prodcatid=" + prodcatid + ", category=" + category + ", products=" + products + "]";
	}

	public int getProdcatid() {
		return prodcatid;
	}

	public void setProdcatid(int prodcatid) {
		this.prodcatid = prodcatid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Id
	@Column(name="prodcat_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int prodcatid;
	@Column(name="category")
	private String category;
	
	public ProdCategory() {
		
	}
	
	@OneToMany(mappedBy = "prodcategory",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Product> products;
	
	public void add(Product tempProd) {
		if(products==null) {
			products=new ArrayList<Product>();
		}
		products.add(tempProd);
		tempProd.setProdcategory(this);
	}
	
}
