package com.charan.dojosandninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.charan.dojosandninja.models.Dojo;
import com.charan.dojosandninja.models.Ninja;
import com.charan.dojosandninja.services.DojoService;
import com.charan.dojosandninja.services.NinjaService;

@Controller
public class DojoController {

	@Autowired
	private DojoService dojoServ;
	
	@Autowired
	private NinjaService ninjaServ;
	
	@GetMapping("/")
	public String allDojos(Model model) {
		
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		
		return "allDojos.jsp";
	}
	
	@GetMapping("/new/dojo")
	public String newDojoPage(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/add/dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
		
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		List<Ninja> dojoNinjas = dojo.getNinjas();
		model.addAttribute("dojoNinjas", dojoNinjas);
		
		return "oneDojo.jsp";
	}
	
}
