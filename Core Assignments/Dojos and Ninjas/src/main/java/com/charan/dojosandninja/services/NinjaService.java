package com.charan.dojosandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.dojosandninja.models.Ninja;
import com.charan.dojosandninja.repos.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
	// Read All
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	// Create
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	// Read One
	public Ninja findNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}
	
	// Update
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	// Delete
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
