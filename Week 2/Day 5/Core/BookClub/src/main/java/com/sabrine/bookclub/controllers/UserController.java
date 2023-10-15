package com.sabrine.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sabrine.bookclub.models.User;
import com.sabrine.bookclub.models.UserLogin;
import com.sabrine.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLoginUser", new UserLogin());
		return"index.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userServ.registerUser(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLoginUser", new UserLogin());
			return"index.jsp";
		}else {
			session.setAttribute("user_id", newUser.getId());
			return"redirect:/books";
		}
	}
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLoginUser") UserLogin newLoginUser, BindingResult result, Model model,
			HttpSession session) {
		User user= userServ.loginUser(newLoginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return"index.jsp";
		}else {
			session.setAttribute("user_id", user.getId());
			return"redirect:/books";
			
		}
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
}
