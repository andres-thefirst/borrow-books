package com.andres.thefirst.books.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.thefirst.books.entity.User;
import com.andres.thefirst.books.repository.IUserData;
import com.andres.thefirst.books.service.IUserBo;

@Service
public class UserBo implements IUserBo{
	
	@Autowired 
	private IUserData userData;


	@Override
	public User findByUser(String user) {
		// TODO Auto-generated method stub
		return userData.findByUser(user);
	}


	@Override
	public User save(String user, String password) {
		// TODO Auto-generated method stub
		User userEntity = new User();
		userEntity.setUser(user);
		userEntity.setPassword(password);
		return userData.save(userEntity);
	}
	
	
}
