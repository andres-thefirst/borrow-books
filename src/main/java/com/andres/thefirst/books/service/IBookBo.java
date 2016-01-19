package com.andres.thefirst.books.service;

import org.springframework.data.domain.Page;

import com.andres.thefirst.books.entity.Book;

public interface IBookBo {
	public Book findByBook(String book);
	public Book save(Book book);
	public Book findById(int id);
	public Book findByUserIdAndImageNull(int id);
	public Page findAll(int page, int size);
}
