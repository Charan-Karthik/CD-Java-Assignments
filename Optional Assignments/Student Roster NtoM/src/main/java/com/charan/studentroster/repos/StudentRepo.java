package com.charan.studentroster.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.studentroster.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
	
	List<Student> findAll();
	
}
