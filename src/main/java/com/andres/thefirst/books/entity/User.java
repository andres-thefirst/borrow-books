package com.andres.thefirst.books.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private boolean enable;

	@Column(nullable=false, length=45)
	private String password;

	@Column(nullable=false, length=45)
	private String user;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="user")
	private List<Book> books;

	//bi-directional many-to-one association to BookBorrowed
	@OneToMany(mappedBy="user")
	private List<BookBorrowed> bookBorroweds;

	//bi-directional many-to-one association to BookVote
	@OneToMany(mappedBy="user")
	private List<BookVote> bookVotes;

	//bi-directional one-to-one association to Reliability
	@OneToOne(mappedBy="user", fetch=FetchType.LAZY)
	private Reliability reliability;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setUser(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setUser(null);

		return book;
	}

	public List<BookBorrowed> getBookBorroweds() {
		return this.bookBorroweds;
	}

	public void setBookBorroweds(List<BookBorrowed> bookBorroweds) {
		this.bookBorroweds = bookBorroweds;
	}

	public BookBorrowed addBookBorrowed(BookBorrowed bookBorrowed) {
		getBookBorroweds().add(bookBorrowed);
		bookBorrowed.setUser(this);

		return bookBorrowed;
	}

	public BookBorrowed removeBookBorrowed(BookBorrowed bookBorrowed) {
		getBookBorroweds().remove(bookBorrowed);
		bookBorrowed.setUser(null);

		return bookBorrowed;
	}

	public List<BookVote> getBookVotes() {
		return this.bookVotes;
	}

	public void setBookVotes(List<BookVote> bookVotes) {
		this.bookVotes = bookVotes;
	}

	public BookVote addBookVote(BookVote bookVote) {
		getBookVotes().add(bookVote);
		bookVote.setUser(this);

		return bookVote;
	}

	public BookVote removeBookVote(BookVote bookVote) {
		getBookVotes().remove(bookVote);
		bookVote.setUser(null);

		return bookVote;
	}

	public Reliability getReliability() {
		return this.reliability;
	}

	public void setReliability(Reliability reliability) {
		this.reliability = reliability;
	}

}