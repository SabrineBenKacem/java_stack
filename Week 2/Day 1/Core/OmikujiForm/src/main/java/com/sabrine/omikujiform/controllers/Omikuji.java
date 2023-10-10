package com.sabrine.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller

public class Omikuji {
	@RequestMapping("/omikuji")
	public String OmikujiShow() {
		return "Omikuji form.jsp";
	}

	
	@RequestMapping(value = "/processOmikuji", method = RequestMethod.POST)
public String OmikujiForm(@RequestParam("number") int number,
		@RequestParam("city") String city,
		@RequestParam("name") String name,
		@RequestParam("hobby") String hobby,
		@RequestParam("livingThing") String livingThing,
		@RequestParam("something") String something,
		HttpSession session, RedirectAttributes flash) {
		
		
		session.setAttribute("keyNumber", number);
		session.setAttribute("keyCity", city);
		session.setAttribute("keyName", name);
		session.setAttribute("keyHobby", hobby);
		session.setAttribute("keyLivingThing", livingThing);
		session.setAttribute("keySomething", something);
	if (number<5 || number > 25) {
		flash.addFlashAttribute("numberErr", "The number must be between 5 and 25");
		return "redirect:/omikuji";
	}
	else {
	
			return "redirect:/display";
	}
}
	@RequestMapping("/display")
	public String OmikujiDisplay() {
		return "display.jsp";
	}	
}
