package com.charan.studentroster.controllers;

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

import com.charan.studentroster.models.AClass;
import com.charan.studentroster.models.Student;
import com.charan.studentroster.services.ClassService;

@Controller
public class ClassController {

	@Autowired
	ClassService classServ;
	
	@GetMapping("/add/class")
	public String addClassPage(@ModelAttribute("newClass") AClass newClass) {
		return "addClass.jsp";
	}
	
	@PostMapping("/add/class")
	public String addClass(@Valid @ModelAttribute("newClass") AClass newClass, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "addClass.jsp";
		} else {
			classServ.createClass(newClass);
			return "redirect:/all/classes";
		}
	}
	
	@GetMapping("/all/classes")
	public String allClasses(Model model) {
		
		List<AClass> allClasses = classServ.allClasses();
		model.addAttribute("allClasses", allClasses);
		
		return "allClasses.jsp";
	}
	
	@GetMapping("/class/{id}")
	public String oneClass(@PathVariable("id") Long classID, Model model) {
		
		AClass thisClass = classServ.findClass(classID);
		model.addAttribute("thisClass", thisClass);
		
		List<Student> studentsInClass = thisClass.getStudents();
		model.addAttribute("studentsInClass", studentsInClass);
		
		return "oneClass.jsp";
	}
	
}
