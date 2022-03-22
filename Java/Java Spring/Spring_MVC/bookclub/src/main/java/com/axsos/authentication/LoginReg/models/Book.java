package com.axsos.authentication.LoginReg.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "title is required!")
	@Size(min = 3, max = 30, message = "title must be between 3 and 30 characters")
	private String title;

	@NotEmpty(message = "author is required!")
	@Size(min = 8, max = 128, message = "author must be between 3 and 128 characters")
	private String author;

	@NotEmpty(message = "thoughts is required!")
	@Size(min = 8, max = 128, message = "thoughts must be between 3 and 128 characters")
	private String thoughts;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user")
    private User user;
    


	public Book() {
	}

	public Book(Long id,
			  String title,
			 String author,
			String thoughts,
			User user) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
