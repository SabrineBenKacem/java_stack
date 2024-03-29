package com.sabrine.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sabrine.loginandregistration.models.LoginUser;
import com.sabrine.loginandregistration.models.User;
import com.sabrine.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser",new User());
		model.addAttribute("newLogin", new LoginUser());
		return"index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userServ.registerUser(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return"index.jsp";
		}
		else {
			session.setAttribute("user_id", newUser.getId());
			return"redirect:/welcome";
		}
		
	}
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user=userServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return"index.jsp";
		}
		else {
			session.setAttribute("user_id", user.getId());
			return"redirect:/welcome";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/welcome")
	public String welcome(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("user_id");
		User loggedUser= userServ.findById(id);
		model.addAttribute("user", loggedUser);
		return"dashboard.jsp";
	}
}
