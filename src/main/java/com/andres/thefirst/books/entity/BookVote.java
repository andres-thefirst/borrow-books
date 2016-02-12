package com.andres.thefirst.books.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the book_vote database table.
 * 
 */
@Entity
@Table(name="book_vote")
@NamedQuery(name="BookVote.findAll", query="SELECT b FROM BookVote b")
public class BookVote implements Serializable {
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "book") )
	@Id
	@GeneratedValue(generator = "generator")
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private boolean value;

	//bi-directional one-to-one association to Book
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Book book;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user", nullable=false)
	private User user;

	public BookVote() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getValue() {
		return this.value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}