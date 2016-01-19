package com.andres.thefirst.books.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.andres.thefirst.books.entity.Book;
import com.andres.thefirst.books.repository.IBookData;
import com.andres.thefirst.books.service.IBookBo;

@Service
public class BookBo implements IBookBo {
	
	@Autowired
	private IBookData bookData;

	@Override
	public Book findByBook(String book) {
		// TODO Auto-generated method stub
		return bookData.findByBook(book);
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookData.save(book);
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return bookData.findById(id);
	}

	@Override
	public Book findByUserIdAndImageNull(int id) {
		// TODO Auto-generated method stub
		return bookData.findByUserIdAndImageNull(id);
	}

	@Override
	public Page findAll(int page, int size) {
		// TODO Auto-generated method stub
		PageRequest request = new PageRequest(page, size);
		return bookData.findAll(request);
	}
}
