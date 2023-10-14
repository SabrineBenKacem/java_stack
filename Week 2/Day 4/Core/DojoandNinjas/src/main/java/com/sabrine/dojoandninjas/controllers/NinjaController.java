package com.sabrine.dojoandninjas.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sabrine.dojoandninjas.models.Dojo;
import com.sabrine.dojoandninjas.models.Ninja;
import com.sabrine.dojoandninjas.services.DojoService;
import com.sabrine.dojoandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaServ;
	@Autowired
	private DojoService dojoServ;

	@GetMapping("/ninjas")
	public String indexNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo>dojosList=dojoServ.findAll();
		model.addAttribute("dojosList", dojosList);
		return "ninjas.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojosList=dojoServ.findAll();
			model.addAttribute("dojosList", dojosList);
			return"ninjas.jsp";
		}else {
			ninjaServ.createNinja(ninja);
			return "redirect:/ninjas";
		}
		
	}
}
