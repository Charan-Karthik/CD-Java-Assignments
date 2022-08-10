package com.charan.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.charan.languages.models.Language;
import com.charan.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	LanguageService languageService;
	
	@GetMapping("/")
	public String originalRedirect() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String mainPage(@ModelAttribute("lang") Language lang, Model model) {
		List<Language> languages = languageService.allLanguages();
		
		model.addAttribute("languages", languages);
		return "dashboard.jsp";
	}
	
	@PostMapping("/languages")
	public String addLanguage(@Valid @ModelAttribute("lang") Language lang, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "dashboard.jsp";
		} else {
			languageService.addLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		
		Language lang = languageService.findOneLang(id);
		model.addAttribute("lang", lang);
		
		return "show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		
		Language lang = languageService.findOneLang(id);
		model.addAttribute("lang", lang);
		
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}/update")
	public String update(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.editLang(lang);
            return "redirect:/";
        }
	}
	
	@DeleteMapping("languages/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		languageService.delete(id);
		return "redirect:/";
	}
	
}
