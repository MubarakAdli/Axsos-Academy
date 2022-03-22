package com.axsos.authentication.LoginReg.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.authentication.LoginReg.models.Book;
import com.axsos.authentication.LoginReg.repositories.BookRepository;
import com.axsos.authentication.LoginReg.repositories.UserRepository;
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository ;
	@Autowired
	private UserService userService;
	
	public BookService(BookRepository bookRepository) {
		
		this.bookRepository = bookRepository;
	}

	public List<Book> getAll(){
		return bookRepository.findAll();
		
	}
	
	
	public Book createBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

}
