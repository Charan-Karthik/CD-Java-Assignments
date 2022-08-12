package com.charan.loginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.charan.loginreg.models.LoginUser;
import com.charan.loginreg.models.User;
import com.charan.loginreg.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User findUser(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

		// Validation for if the email is already in the database
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "regError", "An account with that email already exists");
		}

		// Validation for is the passwords don't match
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "regError", "Password fields must match");
		}

		if (result.hasErrors()) {
			return null;
		}

		// Save user to database after hashing their password
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}

	public User login(LoginUser newLogin, BindingResult result) {

		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());

		// Validation to see if user is in the database or not
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "Incorrect email and/or password");
			return null;
		}

		// Get user from database if user exists
		User user = potentialUser.get();

		// Validation to make sure password entered matches hashed password in database
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Incorrect email and/or password");
		}

		if (result.hasErrors()) {
			return null;
		} else {			
			return user;
		}
	}

}
