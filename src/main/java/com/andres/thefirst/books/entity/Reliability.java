package com.andres.thefirst.books.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the reliability database table.
 * 
 */
@Entity
@Table(name="reliability")
@NamedQuery(name="Reliability.findAll", query="SELECT r FROM Reliability r")
public class Reliability implements Serializable {
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user") )
	@Id
	@GeneratedValue(generator = "generator")
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int down;

	@Column(nullable=false)
	private int up;

	//bi-directional one-to-one association to User
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private User user;

	public Reliability() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDown() {
		return this.down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getUp() {
		return this.up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}