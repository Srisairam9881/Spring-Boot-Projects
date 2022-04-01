package com.example.LoginForm.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.LoginForm.model.Role;
import com.example.LoginForm.model.User;
import com.example.LoginForm.repository.UserRepository;
import com.example.LoginForm.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
  
	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	//@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user=new User(registrationDto.getName(),registrationDto.getEmail(),
				           passwordEncoder.encode(registrationDto.getPassword()),
				           Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
