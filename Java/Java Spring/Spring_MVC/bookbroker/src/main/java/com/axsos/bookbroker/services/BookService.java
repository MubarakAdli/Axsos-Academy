package com.axsos.bookbroker.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.bookbroker.models.Book;
import com.axsos.bookbroker.models.User;
import com.axsos.bookbroker.repositories.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository ;
	@Autowired
	private UserService userService;
	
	public BookService(BookRepository bookRepository,UserService userService) {
		
		this.bookRepository = bookRepository;
		this.userService = userService;
	}

	public List<Book> getAll(){
		return bookRepository.findAll();
		
	}
	
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getAllAvailableBooks(){
		return bookRepository.findByBorrowerNull();
	}
	
	public List<Book> getAllBorrowedBooksByUser(long userId){
		return bookRepository.findByBorrowerId(userId);
	}
	

	
	public void borrowBook(long userBorrowedId,long bookId) {
		Book book = findBook(bookId);
		User user = userService.findUserById(userBorrowedId);
		book.setBorrower(user);
		this.bookRepository.save(book);
	}
	
	public void returnBook(long bookId) {
		Book book = findBook(bookId);
		book.setBorrower(null);
		this.bookRepository.save(book);
	}
	
	
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public void updateBook(Book newBook, Long bookId) {

		Book book = findBook(bookId);
		book.setTitle(newBook.getTitle());
		book.setAuthor(newBook.getAuthor());
		book.setThoughts(newBook.getThoughts());
		bookRepository.save(book);
	}
	
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}

}
