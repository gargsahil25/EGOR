package com.egor.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egor.dao.LoginDAO;
import com.egor.model.LoginDetails;

public class LoginService {
	
	static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	LoginDAO loginDAO; 
	
	public boolean authenticate(String username, String password) {
		
		logger.info("LoginService.authenticate called with username: " + username + " and password: " + password);
		
		List<LoginDetails> loginDetailsList = getLoginDAO().loginByUsernameAndPassword(username, password);
		if (loginDetailsList != null && !loginDetailsList.isEmpty() && loginDetailsList.get(0).getUserId() != null) {
			return true;
		}
		return false;
	}
	
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}


}
