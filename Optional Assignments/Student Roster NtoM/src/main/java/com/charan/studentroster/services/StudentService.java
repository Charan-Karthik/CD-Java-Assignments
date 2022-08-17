package com.charan.studentroster.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.studentroster.models.Student;
import com.charan.studentroster.repos.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	// Read All
		public List<Student> allStudents(){
			return studentRepo.findAll();
		}
		
		// Create
		public Student createStudent(Student s) {
			return studentRepo.save(s);
		}
		
		// Read One
		public Student findStudent(Long id) {
			Optional<Student> maybeStudent = studentRepo.findById(id);
			if(maybeStudent.isPresent()) {
				return maybeStudent.get();
			} else {
				return null;
			}
		}
		
		// Update
		public Student updateStudent(Student s) {
			return studentRepo.save(s);
		}
		
		// Delete
		public void deleteStudent(Long id) {
			studentRepo.deleteById(id);
		}
		
		// Remove from Dorm
		public Student removeStudentFromDojo(Long id) {
			Student student = findStudent(id);
			student.setDorm(null);
			return updateStudent(student);
		}
		
		// Find Students with dorm id=null
		public List<Student> noDormStudents(){
			List<Student> allStudents = allStudents();
			
			List<Student> noDormStudents = new ArrayList<>();
			
			for(Student student : allStudents) {
				if(student.getDorm() == null) {
					noDormStudents.add(student);
				}
			}
			
			return noDormStudents;
		}
//	
}
