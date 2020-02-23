package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.learn.services.UserValidationService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 961494126973643467L;
	private static final String WELCOME_JSP = "WEB-INF/views/welcome.jsp";
	private static final String LOGIN_JSP = "WEB-INF/views/login.jsp";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramName = "name";
		String paramPwd = "pwd";
		String paramError = "errormsg";
		String errorMsg = "Invalid credentials, Please try again!!!";

		String usr = request.getParameter(paramName);
		String pwd = request.getParameter(paramPwd);

		request.setAttribute(paramName, usr);
		UserValidationService validateUser = new UserValidationService();

		if (validateUser.isUserValid(usr, pwd))
			request.getRequestDispatcher(WELCOME_JSP).forward(request, response);
		else {

			request.setAttribute(paramError, errorMsg);
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);

		}

//		  

	}
}
