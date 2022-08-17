package com.charan.studentroster.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.studentroster.models.AClass;
import com.charan.studentroster.models.Student;

@Repository
public interface ClassRepo extends CrudRepository<AClass, Long> {
	List<AClass> findAll();
	
	List<AClass> findAllByStudentsNotContaining(Student student);
}
