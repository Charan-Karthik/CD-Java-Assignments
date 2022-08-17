package com.charan.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.projectmanager.models.Project;
import com.charan.projectmanager.models.User;
import com.charan.projectmanager.repos.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	ProjectRepo projectRepo;

	// Read All
	public List<Project> allProjects() {
		return projectRepo.findAll();
	}

	// Create
	public Project createProject(Project p) {
		return projectRepo.save(p);
	}

	// Read One
	public Project findProject(Long id) {
		Optional<Project> potentialProject = projectRepo.findById(id);
		if (potentialProject.isPresent()) {
			return potentialProject.get();
		} else {
			return null;
		}
	}

	// Update
	public Project updateProject(Project p) {
		return projectRepo.save(p);
	}

	// Delete
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
	// List of Projects that don't have a given user
	public List<Project> projectsWithoutUser(User user){
		return projectRepo.findByAllUsersNotContains(user);
	}
}
