package com.bridgelabz.fundoonotes.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.fundoonotes.model.User;

public interface UserService {

	User registerUser(User user,HttpServletRequest request);
	
	String loginUser(User user,HttpServletRequest request,HttpServletResponse response);

	User activateUser(String token, HttpServletRequest request);

	User updateUser(String token, User user, HttpServletRequest request);

	User deleteUser(String token, HttpServletRequest request);
	
	boolean forgotPassword(String emailId, HttpServletRequest request);

	User resetPassword(User user, String token, HttpServletRequest request);

}

	

