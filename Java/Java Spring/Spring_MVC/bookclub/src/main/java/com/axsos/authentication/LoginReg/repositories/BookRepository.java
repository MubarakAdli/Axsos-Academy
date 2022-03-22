package com.axsos.authentication.LoginReg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.authentication.LoginReg.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book>findAll();
	
}
