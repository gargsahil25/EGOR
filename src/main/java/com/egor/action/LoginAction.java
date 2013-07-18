package com.egor.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egor.model.LoginDetails;
import com.egor.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-services.xml");
	private LoginService loginService;
	
	// Populated by user
	private LoginDetails loginDetails;
	
	public void validate() {
		if (StringUtils.isEmpty(getLoginDetails().getUsername())) {
			addFieldError(loginDetails.getUsername(), "Username cannot be blank");
		}
		if (StringUtils.isEmpty(getLoginDetails().getPassword())) {
			addFieldError(loginDetails.getPassword(), "Username cannot be blank");
		}
	}
	
	public String execute() {
		
		// Set the Login Service
		setLoginService(ctx.getBean("loginService", LoginService.class));
		
		// Debugging
		System.out.println("LoginAction called with username: " + getLoginDetails().getUsername() + 
				" and password: " + getLoginDetails().getPassword());
		
		if (getLoginService().authenticate(getLoginDetails().getUsername(), getLoginDetails().getPassword())) {
			
			// Debugging
			System.out.println("Login service returned SUCCESS");
			
			return "success";
		}		
		
		// Debugging
		System.out.println("Login service returned FAILURE");
		
		return "failure";
	}
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
		System.out.println("Login service is set");
	}
	
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	
}
