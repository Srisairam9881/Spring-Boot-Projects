package com.example.LoginForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LoginForm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
    
}
