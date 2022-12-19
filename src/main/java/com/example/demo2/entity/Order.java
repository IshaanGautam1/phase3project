package com.example.demo2.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column( name="order_id")
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	@ManyToOne
	@JoinColumn(name="product_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Product product;
	@CreationTimestamp
	@Column(name= "time")
	private Time time;
	@CreatedDate
	@Column(name = "order_date")
	private Date date;
}
