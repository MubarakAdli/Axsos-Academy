package com.axsos.bookbroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.bookbroker.models.Book;
import com.axsos.bookbroker.models.User;
import com.axsos.bookbroker.services.BookService;
import com.axsos.bookbroker.services.UserService;



@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	public BookController(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}

	@RequestMapping("/books")
	public String home(Model model, HttpSession session) {

		if (session.getAttribute("user_id") != null) {

			long userId = (long) session.getAttribute("user_id");
			User loggedInUser = userService.findUserById(userId);
			List<Book> books = bookService.getAll();
			model.addAttribute("loggedInUser", loggedInUser);
			model.addAttribute("books", books);

			return "home.jsp";
		}

		return "redirect:/";
	}

	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
		if (session.getAttribute("user_id") != null) {

			return "addbook.jsp";
		}

		return "redirect:/";
	}

	@PostMapping("/books/new")
	public String addbook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {
				model.addAttribute("user_id", session.getAttribute("user_id"));

				return "addbook.jsp";
			} else {

				long userId = (long) session.getAttribute("user_id");
				User loggedUser = userService.findUserById(userId);
				book.setUser(loggedUser);

				bookService.createBook(book);

				return "redirect:/books";
			}
		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			model.addAttribute("user_id", session.getAttribute("user_id"));
			Book book = bookService.findBook(id);
			model.addAttribute("book", book);
			return "bookdet.jsp";
		} else {
			return "redirect:/";
		}
	}
	
                      //	Book Market Methods  //
	
	@RequestMapping("/bookmarket")
	public String allAvailableBooks(Model model, HttpSession session) {

		if (session.getAttribute("user_id") != null) {

			long userId = (long) session.getAttribute("user_id");
			User loggedInUser = userService.findUserById(userId);
			List<Book> availableBooks = bookService.getAllAvailableBooks();
			
			List<Book>borrowedBooks= bookService.getAllBorrowedBooksByUser(userId);
			model.addAttribute("loggedInUser", loggedInUser);
			model.addAttribute("availableBooks", availableBooks);
			model.addAttribute("borrowedBooks", borrowedBooks);

			return "bookmarket.jsp";
		}

		return "redirect:/";
	}
	
	@PutMapping("borrow/{id}")
	public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			long userId = (long) session.getAttribute("user_id");
			bookService.borrowBook(userId, id);			
		}
		return "redirect:/bookmarket";
	}
	
	@PutMapping("return/{id}")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			
			bookService.returnBook(id)	;	
		}
		return "redirect:/bookmarket";
	}
	
	@RequestMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Book book=bookService.findBook(id);
			model.addAttribute("book",book);
			return "editBook.jsp";
		}
		else {
			return "redirect:/";
		
		}
	}
	
	
		
	@PutMapping("/books/{id}/edit")
	public String editBookDeatils(@PathVariable("id") Long id, @Valid@ModelAttribute("book") Book book, BindingResult result,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {

				return "editBook.jsp";
			} else {
				bookService.updateBook(book, id);
				return "redirect:/bookmarket";
			}
		}
			else {
				return "redirect:/";
			}
		}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		
			bookService.deleteBook(id);
			return "redirect:/bookmarket";
		}
}
				
				
				
				
			

