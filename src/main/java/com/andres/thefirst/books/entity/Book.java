package com.andres.thefirst.books.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=200)
	private String author;

	@Column(nullable=false, length=100)
	private String book;

	@Column(nullable=false, length=100)
	private String editorial;

	@Column(length=100)
	private String image;

	@Column(nullable=false, length=30)
	private String isbn;

	@Column(length=300)
	private String resume;

	//bi-directional many-to-one association to BookGenre
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_genre", nullable=false)
	private BookGenre bookGenre;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user", nullable=false)
	private User user;

	//bi-directional many-to-one association to BookBorrowed
	@OneToMany(mappedBy="book")
	private List<BookBorrowed> bookBorroweds;

	//bi-directional one-to-one association to BookVote
	@OneToOne(mappedBy="book", fetch=FetchType.LAZY)
	private BookVote bookVote;

	public Book() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBook() {
		return this.book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public BookGenre getBookGenre() {
		return this.bookGenre;
	}

	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BookBorrowed> getBookBorroweds() {
		return this.bookBorroweds;
	}

	public void setBookBorroweds(List<BookBorrowed> bookBorroweds) {
		this.bookBorroweds = bookBorroweds;
	}

	public BookBorrowed addBookBorrowed(BookBorrowed bookBorrowed) {
		getBookBorroweds().add(bookBorrowed);
		bookBorrowed.setBook(this);

		return bookBorrowed;
	}

	public BookBorrowed removeBookBorrowed(BookBorrowed bookBorrowed) {
		getBookBorroweds().remove(bookBorrowed);
		bookBorrowed.setBook(null);

		return bookBorrowed;
	}

	public BookVote getBookVote() {
		return this.bookVote;
	}

	public void setBookVote(BookVote bookVote) {
		this.bookVote = bookVote;
	}

}