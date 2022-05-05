package com.example.Security.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Security.entity.Role;
import com.example.Security.entity.User;
import com.example.Security.repository.UserRepository;
import com.example.Security.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService  {
    private UserRepository userRepository; 
	
   //private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	
    public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    
	@Override
	public User save(UserRegistrationDto registrationDto) {
		 BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		 User user=new User(registrationDto.getFirstName(),registrationDto.getLastName(),
				              registrationDto.getEmail(),passwordEncoder.encode(registrationDto.getPassword()),
				              Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
