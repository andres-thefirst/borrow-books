package com.andres.thefirst.books.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String status;

	//bi-directional many-to-one association to BookBorrowed
	@OneToMany(mappedBy="status")
	private List<BookBorrowed> bookBorroweds;

	public Status() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BookBorrowed> getBookBorroweds() {
		return this.bookBorroweds;
	}

	public void setBookBorroweds(List<BookBorrowed> bookBorroweds) {
		this.bookBorroweds = bookBorroweds;
	}

	public BookBorrowed addBookBorrowed(BookBorrowed bookBorrowed) {
		getBookBorroweds().add(bookBorrowed);
		bookBorrowed.setStatus(this);

		return bookBorrowed;
	}

	public BookBorrowed removeBookBorrowed(BookBorrowed bookBorrowed) {
		getBookBorroweds().remove(bookBorrowed);
		bookBorrowed.setStatus(null);

		return bookBorrowed;
	}

}