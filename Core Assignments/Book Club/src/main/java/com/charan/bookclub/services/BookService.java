package com.charan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.bookclub.models.Book;
import com.charan.bookclub.repos.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	// Read All
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// Create
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}

	// Read One
	public Book findBook(Long id) {
		Optional<Book> maybeBook = bookRepo.findById(id);
		if (maybeBook.isPresent()) {
			return maybeBook.get();
		} else {
			return null;
		}
	}

	// Update
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}

	// Delete
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
