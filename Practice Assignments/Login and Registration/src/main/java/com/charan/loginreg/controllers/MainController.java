package com.charan.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.charan.loginreg.models.LoginUser;
import com.charan.loginreg.models.User;
import com.charan.loginreg.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String mainPage(Model model, HttpSession session) {
		
		// clear session (done on main page instead of a "/delete" route; all log out buttons will redirect to main page)
		session.invalidate();
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "main.jsp";
	}
	
	@GetMapping("/success")
	public String success(HttpSession session, Model model) {
		// check if there is a user in session
		// we don't want this page to be accessible if there is no user in session
		if(session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("session_user_id");
		User user = userServ.findUser(userID);
		
		// for security reasons we don't want to pass in the entire user object because the user object has the password
		model.addAttribute("userName", user.getUserName());
		
		return "success.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		User user = userServ.register(newUser, result);
		
		if(result.hasErrors()) {
			// re-render login/reg page if any errors
			model.addAttribute("newLogin", new LoginUser());
			return "main.jsp";
		} else {
			session.setAttribute("session_user_id", user.getId()); // add user to session
			return "redirect:/success";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		
		if(result.hasErrors() || user == null) {
			// re-render login/reg page if any errors
			model.addAttribute("newUser", new User());
			return "main.jsp";
		} else {
			session.setAttribute("session_user_id", user.getId()); // add user to session
			return "redirect:/success";
		}
	}
}
