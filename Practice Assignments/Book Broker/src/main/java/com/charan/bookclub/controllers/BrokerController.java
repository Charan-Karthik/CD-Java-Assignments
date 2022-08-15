package com.charan.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		List<Book> allBooks = bookServ.allBooks();
		model.addAttribute("allBooks", allBooks);
		
		return "dashboard.jsp";
	}

}
