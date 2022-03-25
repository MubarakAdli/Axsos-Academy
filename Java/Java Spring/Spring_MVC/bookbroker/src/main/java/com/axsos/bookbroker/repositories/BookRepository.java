package com.axsos.bookbroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.bookbroker.models.Book;



public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book>findAll();
	// Get all books posted by this user
	List<Book> findByUserId(long userId);
	
	// find all available books
	List<Book> findByBorrowerNull();
	
//	find all books borrowed by this user
	List<Book> findByBorrowerId(long id);
	
//	Add borrowed books to this user
//	List<Book> findByBookIdAndUserIdNot(long bookId, long userId);
//	
	
}
