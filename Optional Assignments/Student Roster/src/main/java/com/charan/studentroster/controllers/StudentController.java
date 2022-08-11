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

import com.charan.studentroster.models.Dorm;
import com.charan.studentroster.models.Student;
import com.charan.studentroster.services.DormService;
import com.charan.studentroster.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	@Autowired
	private DormService dormServ;
	
	@GetMapping("/add/student")
	public String addStudentPage(@ModelAttribute("student") Student student, Model model) {
		
		List<Dorm> dorms = dormServ.allDorms();
		model.addAttribute("dorms", dorms);
		
		return "addStudent.jsp";
	}
	
	@PostMapping("/add/student")
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dorm> dorms = dormServ.allDorms();
			model.addAttribute("dorms", dorms);
			return "addStudent.jsp";
		} else {
			studentServ.createStudent(student);
			return "redirect:/";
		}
	}
	
	@GetMapping("/remove/student/{id}")
	public String removeStudent(@PathVariable("id") Long id) {
		
		Student student = studentServ.findStudent(id);
		Dorm student_dorm = student.getDorm();
		Long dorm_id = student_dorm.getId();
		
		studentServ.removeStudentFromDojo(id);
		
		return "redirect:/dorm/" + dorm_id + "/students";
	}
}
