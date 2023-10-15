package com.sabrine.bookclub.controllers;

import java.util.List;

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

import com.sabrine.bookclub.models.Book;
import com.sabrine.bookclub.models.User;
import com.sabrine.bookclub.services.BookService;
import com.sabrine.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
@Autowired
	private BookService bookServ;
@Autowired
private UserService userServ;

@GetMapping("/books")
public String showBooks(@ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
	
	Long id = (Long) session.getAttribute("user_id");
	User loggedUser= userServ.findById(id);
	model.addAttribute("user", loggedUser);
	List<Book> allbooks= bookServ.findAllBook();
	model.addAttribute("listOfBooks", allbooks);
	return"books.jsp";
}

@GetMapping("/books/new")
public String createForm(@ModelAttribute("book") Book book) {
	return"addBook.jsp";
}

@PostMapping("/books/new")
public String createBook(@ Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
	if (result.hasErrors()) {
		return"addBook.jsp";
	}
	else {
		
	
	
	Long id = (Long) session.getAttribute("user_id");
	User loggedUser= userServ.findById(id);
	book.setPostedBy(loggedUser);
	bookServ.createBook(book);
	return"redirect:/books";
	}
}

@GetMapping("/books/{id}")

public String showDetailsBook(@PathVariable("id") Long id, Model model, HttpSession session ) {
	
	Long userId= (Long) session.getAttribute("user_id");
	User loggedUser=userServ.findById(userId);
	model.addAttribute("loggedUser", loggedUser);
	Book thisBook=bookServ.findOneBook(id);
	model.addAttribute("book", thisBook);
	return"onebook.jsp";
}

@GetMapping("books/{id}/edit")
public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book,Model model, HttpSession session) {
	Long userId= (Long) session.getAttribute("user_id");
	User loggedUser=userServ.findById(userId);
	model.addAttribute("loggedUser", loggedUser);
	Book thisBook=bookServ.findOneBook(id);
	model.addAttribute("book", thisBook);
	return"edit.jsp";
}

@PutMapping("books/{id}/edit")
public String updateBook(@ Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
		HttpSession session) {
	if (result.hasErrors()) {
		return"edit.jsp";
	}
	else {
		Book oldBook= bookServ.findOneBook(book.getId());
		book.setPostedBy(oldBook.getPostedBy());
	
	bookServ.updateBook(book);
	Long userId= (Long) session.getAttribute("user_id");
	User loggedUser=userServ.findById(userId);
	model.addAttribute("loggedUser", loggedUser);
	return"redirect:/books";
}
}

@DeleteMapping("/books/{id}")
public String deleteBook(@PathVariable("id")Long id) {
	
	bookServ.deleteBook(id);
	return"redirect:/books";
}
}
