package com.andres.thefirst.books.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andres.thefirst.books.entity.Book;

@Repository
public interface IBookData extends JpaRepository<Book, Long>{
	Book findByBook(String book);
	Book findById(int id);
	
	@Query("SELECT b FROM Book b INNER JOIN b.user u WHERE u.id = :id and b.image is null")
	Book findByUserIdAndImageNull(@Param("id") int id);
	
}
