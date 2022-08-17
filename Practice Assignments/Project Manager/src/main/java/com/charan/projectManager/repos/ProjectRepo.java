package com.charan.projectmanager.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.projectmanager.models.Project;
import com.charan.projectmanager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {
	
	List<Project> findAll();
	
	List<Project> findByAllUsersNotContains(User user);
	
}
