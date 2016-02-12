package com.andres.thefirst.books.service;

import java.util.List;

import com.andres.thefirst.books.entity.BookGenre;

public interface IBookGenreBo {
	public List<BookGenre> findAll();
}
