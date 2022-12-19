package com.example.demo2.dao;

import java.util.List;

import com.example.demo2.entity.User;




public interface UsersDAO {
	public User findByusername(String username);
	public void addUsers(User theUser);
	public List<User> getall();
}
