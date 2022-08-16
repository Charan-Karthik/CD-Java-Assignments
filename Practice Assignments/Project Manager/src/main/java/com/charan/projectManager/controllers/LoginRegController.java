package com.charan.projectManager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.charan.projectManager.models.LoginUser;
import com.charan.projectManager.models.User;
import com.charan.projectManager.services.UserService;

@Controller
public class LoginRegController {

	@Autowired
	UserService userServ;

	@GetMapping("/")
	public String loginRegPage(Model model, HttpSession session) {
		// clear session
		session.invalidate();

		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());

		return "loginReg.jsp";
	}

	@GetMapping("/dashboard")
	public String welcomePage(HttpSession session, Model model) {
		// we don't want this page to render if there is no user in session
		if (session.getAttribute("session_user_id") == null) {
			return "redirect:/";
		}
		
		Long userID = (Long) session.getAttribute("session_user_id");
		User user = userServ.findUser(userID);
		
		model.addAttribute("user", user);
		
		return "dashboard.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		User user = userServ.register(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "loginReg.jsp";
		} else {
			session.setAttribute("session_user_id", user.getId());
			return "redirect:/dashboard";
		}
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);

		if (result.hasErrors() || user == null) {
			// re-render login/reg page if any errors
			model.addAttribute("newUser", new User());
			return "loginReg.jsp";
		} else {
			session.setAttribute("session_user_id", user.getId()); // add user to session
			return "redirect:/dashboard";
		}
	}

}
