package com.andres.thefirst.books.back;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andres.thefirst.books.entity.Book;
import com.andres.thefirst.books.entity.User;
import com.andres.thefirst.books.repository.IBookData;
import com.andres.thefirst.books.repository.IUserData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config/spring-core.xml"})
public class TestDaoBook {

	@Autowired
	private IBookData bookData;
	
	@Autowired
	private IUserData userData;
	
	@Test
	@Transactional
	@Rollback(false)
	public void insert(){
		try{
			User user = userData.findByUser("firts");
			
			Book book = new Book();
			book.setBook("book");
			book.setEditorial("book");
			book.setImage("book");
			book.setIsbn("book");
			book.setResume("book");
			book.setAuthor("book");
			book.setUser(user);
			
			bookData.save(book);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	public void consult(){
		
		PageRequest request = new PageRequest(1,34);

		Page<User> page = userData.findAll(request);
		
		System.out.println(page.getTotalElements());
		System.out.println(page.getTotalPages());
		
		List<User> listUser = page.getContent();
		
		for(User item: listUser){
			System.out.println(item.getUser());
		}
	}
}
