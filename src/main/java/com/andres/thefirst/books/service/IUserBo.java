package com.andres.thefirst.books.service;

import com.andres.thefirst.books.entity.User;

public interface IUserBo {
	
	public User findByUser(String user);
	public User save(String user, String password);
}
