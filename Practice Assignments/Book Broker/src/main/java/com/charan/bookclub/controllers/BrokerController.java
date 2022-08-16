package com.charan.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charan.bookclub.models.Book;
import com.charan.bookclub.models.User;
import com.charan.bookclub.services.BookService;
import com.charan.bookclub.services.UserService;

@Controller
public class BrokerController {

	@Autowired
	private UserService userServ;

	@Autowired
	private BookService bookServ;

	@RequestMapping("/bookmarket")
	public String bookMarketMain(Model model, HttpSession session) {
		// don't want to render this page unless there is a user logged in
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("session_user_id");
		User loggedInUser = userServ.findUser(userID);
		String loggedInUserName = loggedInUser.getUserName();
		model.addAttribute("userName", loggedInUserName);
		
		List<Book> userBorrowed = bookServ.booksBorrowed(loggedInUser);
		model.addAttribute("borrowed", userBorrowed);
		
		// remove the book from the unborrowed list if it's borrowed
		List<Book> unborrowed = bookServ.allBooks();
		for(Book b : userBorrowed) {
			unborrowed.remove(b);
		}
		model.addAttribute("unborrowed", unborrowed);
		
		return "dashboard.jsp";
	}

	@GetMapping("/bookmarket/borrow/{id}")
	private String borrow(@PathVariable("id") Long bookID, HttpSession session) {
		// don't want to render this page unless there is a user logged in
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}
		
		Book b = bookServ.findBook(bookID);
		// Doing it all in one line to be ~different~
		User u = userServ.findUser((Long) session.getAttribute("session_user_id"));
		
		bookServ.addBorrowingUser(b, u);
		
		return "redirect:/bookmarket";
	}
	
	@GetMapping("/bookmarket/return/{id}")
	private String returnBook(@PathVariable("id") Long bookID, HttpSession session) {
		
		Book b = bookServ.findBook(bookID);
		b.setBorrower(null);
		bookServ.updateBook(b);
		
		return "redirect:/bookmarket";
	}

}
