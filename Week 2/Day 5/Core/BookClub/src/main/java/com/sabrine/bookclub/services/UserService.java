package com.sabrine.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sabrine.bookclub.models.User;
import com.sabrine.bookclub.models.UserLogin;
import com.sabrine.bookclub.repositories.UserRepository;

@Service
public class UserService {
@Autowired
private UserRepository userRepo;


public User registerUser(User newUser, BindingResult result) {
	Optional<User> potentialUser= userRepo.findByEmail(newUser.getEmail());
	if(potentialUser.isPresent()) {
		result.rejectValue("email", "registerError", "Email is taken");
	}
	if(! newUser.getPassword().equals(newUser.getConfirmPassword())){
		result.rejectValue("password", "registerError", "Passwords DONT match!");
	}
	if(result.hasErrors()) {
		return null;
	}else {
		String hashPW= BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashPW);
		return userRepo.save(newUser);
	}
}

public User loginUser(UserLogin newLoginUser, BindingResult result) {
	Optional <User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
	if(! potentialUser.isPresent()) {
		result.rejectValue("email", "loginError", "incorrect Email");
	}else {
		User user = potentialUser.get();
		if(! BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "loginError", "Password incorrect");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			return user;
		}
	}
	return null;
}

public User findById(Long id) {
	Optional<User> mybeFound= userRepo.findById(id);
	if (mybeFound.isPresent()) {
		return mybeFound.get();
	}else {
		return null;
	}
}


}
