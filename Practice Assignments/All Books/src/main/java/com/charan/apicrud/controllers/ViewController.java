package com.charan.apicrud.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.charan.apicrud.models.Book;
import com.charan.apicrud.services.BookService;

@Controller
public class ViewController {
	
	// import BookService
	private final BookService bookServ;
	
	public ViewController(BookService bookServ) {
		this.bookServ = bookServ;
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/books";
	}
	
	@RequestMapping("/books")
	public String bookTable(Model model) {
		
		// grab all the books from the service
		List<Book> allDaBooks = bookServ.allBooks();
//		System.out.println(allDaBooks);
		
		model.addAttribute("allDaBooks",allDaBooks);
		
		return "books.jsp";
	}
	
	
	// show page with one book's info
	@RequestMapping("/books/{id}")
	public String oneBook(@PathVariable("id") Long id, Model model) {
		
		// go to database with the id and get the book
		Book thisBook = bookServ.findBook(id);
		
		// pass the book to the jsp page
		model.addAttribute("thisBook", thisBook);
		
		return "oneBook.jsp";
	}
	
	
	@RequestMapping("/create")
	public String createPage(){
		return "create.jsp";
	}
	
	@RequestMapping(value="/processBook", method=RequestMethod.POST)
	public String createMethod(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") int numberOfPages
			) {
		
		Book newBook = new Book(title, description, language, numberOfPages);
		bookServ.createBook(newBook);
		
		return "redirect:/";
	}
	
}
