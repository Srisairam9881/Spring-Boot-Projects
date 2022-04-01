package com.example.LoginForm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.LoginForm.model.User;
import com.example.LoginForm.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}
