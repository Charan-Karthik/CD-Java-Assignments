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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charan.studentroster.models.Dorm;
import com.charan.studentroster.models.Student;
import com.charan.studentroster.services.DormService;
import com.charan.studentroster.services.StudentService;

@Controller
public class DormController {
	
	@Autowired
	private DormService dormServ;
	
	@Autowired
	private StudentService studentServ;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Dorm> dorms = dormServ.allDorms();
		model.addAttribute("dorms", dorms);
		
		return "main.jsp";
	}
	
	@GetMapping("/add/dorm")
	public String addDormPage(@ModelAttribute("dorm") Dorm dorm) {
		
		return "addDorm.jsp";
	}
	
	@PostMapping("/add/dorm")
	public String addDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addDorm.jsp";
		} else {
			dormServ.createDorm(dorm);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dorm/{id}/students")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		Dorm dorm = dormServ.findDorm(id);
		model.addAttribute("dorm", dorm);
		
		List<Student> students = dorm.getStudents();
		model.addAttribute("students", students);
		
		List<Student> noDormStudents = studentServ.noDormStudents();
		model.addAttribute("noDormStudents", noDormStudents);
		
		boolean empty = noDormStudents.isEmpty();
		model.addAttribute("emptyQ", empty);
		
		return "oneDorm.jsp";
	}
	
	@PutMapping("/add/student/to/dorm/{id}")
	public String addStudentToDorm(@PathVariable("id") Long dormID, @RequestParam(name="studentId", required=false) Long studentId) {
		

		
		Student student = studentServ.findStudent(studentId);

		
		Dorm dorm = dormServ.findDorm(dormID);

		

		student.setDorm(dorm);
		studentServ.updateStudent(student);
		
		return "redirect:/dorm/"+dormID+"/students";
	}
}
