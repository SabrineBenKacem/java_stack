package com.sabrine.dojoandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sabrine.dojoandninjas.models.Dojo;

import com.sabrine.dojoandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller

public class DojoController {
	@Autowired
	private DojoService dojoServ;
	
	
	@GetMapping("/dojos")
	public String show( @ModelAttribute("dojo") Dojo dojo) {
	return "dojos.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
		
			return "dojos.jsp";
			
		}else {
			dojoServ.createDojo(dojo);
		
			return "redirect:/dojos";
		}
	}
	@GetMapping("/dojos/{id}")
	public String showDojo(@ PathVariable("id") Long id, Model model) {
		Dojo oneDojo=dojoServ.findDojo(id);
		model.addAttribute("oneDojo", oneDojo);
		return "show dojo.jsp";
	}
}
