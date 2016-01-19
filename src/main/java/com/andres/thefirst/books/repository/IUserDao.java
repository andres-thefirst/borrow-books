package com.andres.thefirst.books.repository;

import java.util.List;

import com.andres.thefirst.books.entity.User;

public interface IUserDao {
	public List<User> findAll();
	public void create( User entity );
	public User findOne( int id );
	public User findByName(String name);
	public User update( User entity );
	public void delete( User entity );
	public void deleteById( int entityId );
}
