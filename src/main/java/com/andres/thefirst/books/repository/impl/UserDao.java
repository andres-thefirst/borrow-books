package com.andres.thefirst.books.repository.impl;

import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import com.andres.thefirst.books.entity.User;
import com.andres.thefirst.books.repository.IUserDao;

@Repository
public class UserDao extends AJpaDao< User > implements IUserDao{
	
   public UserDao(){
      setClazz(User.class );
   }

@Override
public User findByName(String name) {
	// TODO Auto-generated method stub
	
	return null;
}
   
}
