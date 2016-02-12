package com.andres.thefirst.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.thefirst.books.entity.BookGenre;

@Repository
public interface IBookGenreData extends JpaRepository<BookGenre, Long>{

}
