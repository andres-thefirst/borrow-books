package com.andres.thefirst.books.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the book_genre database table.
 * 
 */
@Entity
@Table(name="book_genre")
@NamedQuery(name="BookGenre.findAll", query="SELECT b FROM BookGenre b")
public class BookGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=75)
	private String genre;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="bookGenre")
	private List<Book> books;

	public BookGenre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setBookGenre(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setBookGenre(null);

		return book;
	}

}