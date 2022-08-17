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

import com.charan.studentroster.models.AClass;
import com.charan.studentroster.models.Dorm;
import com.charan.studentroster.models.Student;
import com.charan.studentroster.services.ClassService;
import com.charan.studentroster.services.DormService;
import com.charan.studentroster.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	@Autowired
	private DormService dormServ;
	
	@Autowired
	private ClassService classServ;
	
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
	
	@GetMapping("/student/{id}")
	public String oneStudent(@PathVariable("id") Long studentID, Model model) {
		
		Student thisStudent = studentServ.findStudent(studentID);
		model.addAttribute("thisStudent", thisStudent);
		
		List<AClass> classesStudentIsNotIn = classServ.classesWithoutStudent(thisStudent);
		model.addAttribute("classesStudentIsNotIn", classesStudentIsNotIn);
		
		return "oneStudent.jsp";
	}
	
	@PutMapping("/student/{id}/add/class")
	public String addClassToStudent(@PathVariable("id") Long studentID, @RequestParam("classID") Long classID) {
		
//		System.out.println(studentID);
//		System.out.println(classID);
		
		Student student = studentServ.findStudent(studentID);
		AClass classToAdd = classServ.findClass(classID);
		
		student.getClasses().add(classToAdd);
		studentServ.updateStudent(student);
		
		
		return "redirect:/student/"+studentID;
	}
	
	@GetMapping("/student/{studentID}/drop/class/{classID}")
	public String dropClass(@PathVariable("studentID") Long studentID, @PathVariable("classID") Long classID) {
		
		Student student = studentServ.findStudent(studentID);
		AClass classToRemove = classServ.findClass(classID);
		
		student.getClasses().remove(classToRemove);
		studentServ.updateStudent(student);
		
		return "redirect:/student/"+studentID;
	}
}
