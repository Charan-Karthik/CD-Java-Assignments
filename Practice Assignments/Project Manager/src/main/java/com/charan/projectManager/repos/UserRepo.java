package com.charan.projectmanager.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.projectmanager.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	List<User> findAll();

	// Check if an email is in database
	Optional<User> findByEmail(String email);

}
