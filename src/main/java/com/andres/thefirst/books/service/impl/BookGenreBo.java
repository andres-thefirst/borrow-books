package com.andres.thefirst.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.thefirst.books.entity.BookGenre;
import com.andres.thefirst.books.repository.IBookGenreData;
import com.andres.thefirst.books.service.IBookGenreBo;

@Service
public class BookGenreBo implements IBookGenreBo{
	
	@Autowired
	private IBookGenreData genreData;

	@Override
	public List<BookGenre> findAll() {
		// TODO Auto-generated method stub
		return genreData.findAll();
	}

}
