package com.charan.studentroster.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.studentroster.models.Dorm;

@Repository
public interface DormRepo extends CrudRepository<Dorm, Long> {

	List<Dorm> findAll();	
	
}
