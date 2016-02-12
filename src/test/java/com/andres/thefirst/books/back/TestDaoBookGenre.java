package com.andres.thefirst.books.back;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andres.thefirst.books.entity.BookGenre;
import com.andres.thefirst.books.service.IBookGenreBo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config/spring-core.xml"})
public class TestDaoBookGenre {
	
	@Autowired
	public IBookGenreBo bookGenreBo;

	
	@Test
	@Transactional
	public void findAll(){
		
		List<BookGenre> listGenre = bookGenreBo.findAll();
		
		for(BookGenre item: listGenre){
			System.out.println("Item name: " + item.getGenre());
		}
		
		assertNotEquals(true, listGenre.isEmpty());
	}
}
