package com.example.demo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

}
