package com.charan.dojosandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.dojosandninja.models.Dojo;
import com.charan.dojosandninja.repos.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;
	
	// Read All
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	// Create
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// Read One
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}
	
	// Update
	public Dojo updateDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// Delete
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
