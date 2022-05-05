package com.example.Security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Security.entity.User;
import com.example.Security.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

}
