package com.andres.thefirst.books.back;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andres.thefirst.books.entity.User;
import com.andres.thefirst.books.repository.IUserDao;
import com.andres.thefirst.books.repository.IUserData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config/spring-core.xml"})
public class TestDaoUser {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IUserData userData;
	
	@Test
	@Transactional
	@Rollback(false)
	public void insert(){
		try{
			
		User user = new User();
		user.setPassword("1234");
		user.setUser("part");
		user.setEnable(true);
		
		//userDao.create(user);
		userData.save(user);
				
		
		List<User> list = userDao.findAll();
		
		for(User element : list){
			System.out.println(element.getUser());
		}
		
		System.out.print("Hola Mundo!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional(readOnly=true)
	public void find(){
		
		try{
			System.out.println("Iniciando...");
			
			User user = userData.findByUserAndPassword("firts", "1234");
			
			System.out.println("Usuario:" + user.getUser());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
