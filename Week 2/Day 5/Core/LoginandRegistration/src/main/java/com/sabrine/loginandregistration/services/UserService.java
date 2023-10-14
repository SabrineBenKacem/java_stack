package com.sabrine.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sabrine.loginandregistration.models.LoginUser;
import com.sabrine.loginandregistration.models.User;
import com.sabrine.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User registerUser(User newUser, BindingResult result) {
		
		Optional<User> potentialUser=userRepo.findByEmail(newUser.getEmail());
			if( potentialUser.isPresent()) {
				result.rejectValue("email", "registerError", "Email is taken!!!");
		}
			if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
				result.rejectValue("password", "registerError", "passwords dose not match!!");
			}
			if(result.hasErrors()) {
				return null;
			}else {
				String hashPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
				newUser.setPassword(hashPW);
				return userRepo.save(newUser);
			}
			
		
	}
	
	public User login(LoginUser newLoggedUser, BindingResult result ) {
		Optional<User>potensialUser= userRepo.findByEmail(newLoggedUser.getEmail());
		if (!potensialUser.isPresent()) {
			result.rejectValue("email", "loginError", "email not found");
		}
		else {
			User user = potensialUser.get();
		if
			(! BCrypt.checkpw(newLoggedUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "loginError", "password dose not match!!!");
		}
		if(result.hasErrors()) {
			return null;
		}else {
			return user;
		}
		
	}
		return null;
	}
	
	public User findById(Long id) {
		Optional<User> maybeUser= userRepo.findById(id);
		if (maybeUser.isPresent()) {
			return maybeUser.get();
			
		}else {
			return null;
		}
	}
}
