package com.greatLearning.ApiEmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatLearning.ApiEmployeeManagement.dao.UserRepository;
import com.greatLearning.ApiEmployeeManagement.entity.User;
import com.greatLearning.ApiEmployeeManagement.security.EmployeeDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public UserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new EmployeeDetails(user);
	}
	
	public void addUser(User user) {
		user.setPassword(encoder().encode(user.getPassword()));
		userRepository.save(user);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
