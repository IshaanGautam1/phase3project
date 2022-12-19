package com.example.demo2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column( name="prod_id")
	private int productid;
	@Column(name="product_name")
	private String productname;
	@Column(name="img_url")
	private String imgurl;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="prodcat_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private ProdCategory prodcategory;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public ProdCategory getProdcategory() {
		return prodcategory;
	}
	public void setProdcategory(ProdCategory prodcategory) {
		this.prodcategory = prodcategory;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", imgurl=" + imgurl
				+ ", prodcategory=" + prodcategory + "]";
	}
	public Product() {
		
	}
	@OneToMany(mappedBy = "product")
	private List<Order> orders;
	
	public void add(Order theorder) {
		
		if(orders==null) {
			List<Order> orders =new ArrayList<Order>();		
		}
		orders.add(theorder);
		theorder.setProduct(this);
	}
}
