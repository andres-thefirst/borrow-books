package com.andres.thefirst.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.thefirst.books.entity.User;

@Repository
public interface IUserData extends JpaRepository<User, Long>{
	
	public User findByUserAndPassword(String user, String password);
	public User findByUser(String user);
}
