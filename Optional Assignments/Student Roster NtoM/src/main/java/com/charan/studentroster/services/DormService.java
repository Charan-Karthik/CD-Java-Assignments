package com.charan.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.studentroster.models.Dorm;
import com.charan.studentroster.repos.DormRepo;

@Service
public class DormService {

	@Autowired
	private DormRepo dormRepo;

	// Read All
	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}

	// Create
	public Dorm createDorm(Dorm d) {
		return dormRepo.save(d);
	}

	// Read One
	public Dorm findDorm(Long id) {
		Optional<Dorm> maybeDorm = dormRepo.findById(id);
		if (maybeDorm.isPresent()) {
			return maybeDorm.get();
		} else {
			return null;
		}
	}

	// Update
	public Dorm updateDorm(Dorm d) {
		return dormRepo.save(d);
	}

	// Delete
	public void deleteDorm(Long id) {
		dormRepo.deleteById(id);
	}
}
