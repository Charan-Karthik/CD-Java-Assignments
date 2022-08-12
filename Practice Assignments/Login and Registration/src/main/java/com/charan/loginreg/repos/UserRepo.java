package com.charan.loginreg.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.loginreg.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	// for checking a user with that email is in the database or not
	Optional<User> findByEmail(String email);
	
}
