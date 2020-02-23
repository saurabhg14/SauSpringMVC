package com.spring.learn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.learn.services.UserValidationService;

@Controller
public class LoginController {
	
	//private UserValidationService validateService = new UserValidationService();
	@Autowired
	UserValidationService validateService;

	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test()
	{
		return "First Controller of Spring MVC";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String renderLoginPage()
	{
		return "login";
	}
	
			
	@RequestMapping(value = "/check", method=RequestMethod.POST)
	public String validateCredentials(@RequestParam String name, @RequestParam String pwd, ModelMap model)
	{
		if(validateService.isUserValid(name, pwd))
		{
			model.put("name",name);
			model.put("pwd",pwd);
			return "welcome";
		}
		else
		{
			String paramError = "errormsg";
			String errorMsg = "Invalid credentials, Please try again!!!";
			model.put(paramError,errorMsg);
			model.put("name",name);
			return "login";
		}
		
	}
	


}
