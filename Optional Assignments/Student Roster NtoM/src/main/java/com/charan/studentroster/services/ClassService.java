package com.charan.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.studentroster.models.AClass;
import com.charan.studentroster.models.Student;
import com.charan.studentroster.repos.ClassRepo;

@Service
public class ClassService {

	@Autowired
	private ClassRepo classRepo;

	// Read All
	public List<AClass> allClasses() {
		return classRepo.findAll();
	}

	// Create
	public AClass createClass(AClass c) {
		return classRepo.save(c);
	}

	// Read One
	public AClass findClass(Long id) {
		Optional<AClass> potentialClass = classRepo.findById(id);
		if (potentialClass.isPresent()) {
			return potentialClass.get();
		} else {
			return null;
		}
	}
	
	// Classes that a student is not in
	public List<AClass> classesWithoutStudent(Student student){
		return classRepo.findAllByStudentsNotContaining(student);
	}
}
