package com.greatLearning.ApiEmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatLearning.ApiEmployeeManagement.dao.UserRepository;
import com.greatLearning.ApiEmployeeManagement.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		user.setPassword(encoder().encode(user.getPassword()));
		userRepository.save(user);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
