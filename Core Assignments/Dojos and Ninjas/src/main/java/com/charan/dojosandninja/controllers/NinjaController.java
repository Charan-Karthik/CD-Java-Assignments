package com.charan.dojosandninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.charan.dojosandninja.models.Dojo;
import com.charan.dojosandninja.models.Ninja;
import com.charan.dojosandninja.services.DojoService;
import com.charan.dojosandninja.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaServ;
	
	@Autowired
	private DojoService dojoServ;
	
	@GetMapping("/new/ninja")
	public String newNinjaPage(@ModelAttribute("ninja") Ninja ninja, Model model){
		
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		
		return "newNinja.jsp";
	}
	
	@PostMapping("/add/ninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			ninjaServ.createNinja(ninja);
			return "redirect:/";
		}
	}
	
}
