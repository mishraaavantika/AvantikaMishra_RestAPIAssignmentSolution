package com.greatLearning.ApiEmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.ApiEmployeeManagement.entity.User;
import com.greatLearning.ApiEmployeeManagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {
		
		userService.addUser(user);
	} 
}
