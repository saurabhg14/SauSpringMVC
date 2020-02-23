package com.spring.learn.services;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {


	public boolean isUserValid(String user, String pwd)
	{
		if (user.equals("Saurabh") && pwd.equals("Password"))
			return true;
		
		return false;
	}
}
