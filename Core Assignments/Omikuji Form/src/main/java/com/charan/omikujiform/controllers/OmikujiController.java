package com.charan.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OmikujiController {
	
	@RequestMapping("/")
	public String form() {
		return "form.jsp";
	}
	
	@RequestMapping(value = "/fortune", method=RequestMethod.POST)
	public String formSubmit(
			@RequestParam(value="number") int number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="occupation") String occupation,
			@RequestParam(value="organism") String organism,
			@RequestParam(value="message") String message,
			Model model, RedirectAttributes flash) {
		
		if(number < 5 || number > 25) {
			flash.addFlashAttribute("numberError", "Please enter a number between 5 and 25 (inclusive)");
			return "redirect:/";
		}
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("occupation", occupation);
		model.addAttribute("organism", organism);
		model.addAttribute("message", message);
		
		return "fortune.jsp";
	}
	
//	@RequestMapping("/fortune")
//	public String fortune() {
//		return "fortune.jsp";
//	}
}
