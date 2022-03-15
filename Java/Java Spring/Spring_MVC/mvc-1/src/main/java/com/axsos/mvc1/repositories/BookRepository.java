package com.axsos.mvc1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc1.models.Book;

//import antlr.collections.List;

//...
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// this method retrieves all the books from the database
	List<Book> findAll();

	// this method finds books with descriptions containing the search string
	List<Book> findByDescriptionContaining(String search);

}

