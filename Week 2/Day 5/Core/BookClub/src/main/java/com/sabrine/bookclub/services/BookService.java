package com.sabrine.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabrine.bookclub.models.Book;
import com.sabrine.bookclub.repositories.BookRepository;

@Service
public class BookService {
@Autowired
private BookRepository bookRepo;

public List<Book> findAllBook() {
	return bookRepo.findAll();
}

public Book createBook(Book newBook) {
	return bookRepo.save(newBook);
}

public Book findOneBook(Long id) {
	Optional<Book> mybeBook= bookRepo.findById(id);
	if(mybeBook.isPresent()) {
		return mybeBook.get();
	}else {
		return null;
	}
}
public Book updateBook(Book updatedBook) {
	return bookRepo.save(updatedBook);
}

public void deleteBook(Long id) {
	bookRepo.deleteById(id);
}
}
