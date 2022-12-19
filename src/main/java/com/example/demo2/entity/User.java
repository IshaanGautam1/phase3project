package com.example.demo2.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column( name="id")
	private int id;
	@Column( name="username")
	private String username;
	@Column( name="password")
	private String password;
	@Column( name="role")
	private String role;
	@Column(name="active")
	private int active;
@OneToMany(mappedBy = "user")
	private List<Order> orders;

public void add(Order theorder) {
	if(orders==null) {
		orders = new ArrayList<Order>();
	}
	orders.add(theorder);
	theorder.setUser(this);
}
}
