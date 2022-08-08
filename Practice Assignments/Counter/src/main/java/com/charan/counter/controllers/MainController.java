package com.charan.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String welcome(HttpSession session) {
		if(session.getAttribute("count") == null) {		
			session.setAttribute("count", 0);
		} else {
			Integer increment = (Integer) session.getAttribute("count");
			increment ++;
			session.setAttribute("count", increment);
		}
		
		return "welcome.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer increment = (Integer) session.getAttribute("count");
			increment ++;
			session.setAttribute("count", increment);
		}
		
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/counter";
	}
	
	@RequestMapping("/add/two")
	public String addTwo(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer increment = (Integer) session.getAttribute("count");
			increment ++;
			session.setAttribute("count", increment);
		}
		
		return "redirect:/counter";
	}
}
