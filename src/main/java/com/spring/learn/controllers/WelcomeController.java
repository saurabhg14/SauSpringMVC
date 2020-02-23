package com.spring.learn.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
//	@RequestMapping(value = "/welcome", method=RequestMethod.POST)
//	public String welcomePage(ModelMap model)
//	{
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if(principal instanceof UserDetails)
//		{
//			model.addAttribute("name", ((UserDetails) principal).getUsername().concat(" (Post-Principal)"));
//		}
//		return "welcome";
//	}

	
	@RequestMapping(value = "/welcome", method=RequestMethod.GET)
	public String renderWelcomePage(ModelMap model)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
		{
			model.addAttribute("name", ((UserDetails) principal).getUsername().concat(" (Get-Principal)"));
		}
		return "welcome";
	}

}
