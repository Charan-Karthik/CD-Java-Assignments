package com.charan.apicrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charan.apicrud.models.Book;
import com.charan.apicrud.repositories.BookRepository;

@Service
public class BookService {
// C R U D happens here
	
	// adding the book repository as a dependency (bringing in the repository and using it locally)
	private final BookRepository bookRepository; // private means variable cannot be changed

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books (READ ALL)
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book (CREATE)
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book (READ ONE)
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// update
	public Book updateBook(Long id, String title, String description, String lang, Integer numOfPages) {
		Book toBeUpdated = findBook(id);
		
		toBeUpdated.setTitle(title);
		toBeUpdated.setDescription(description);
		toBeUpdated.setLanguage(lang);
		toBeUpdated.setNumberOfPages(numOfPages);
		
		return bookRepository.save(toBeUpdated);
	}
	
	// delete
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
