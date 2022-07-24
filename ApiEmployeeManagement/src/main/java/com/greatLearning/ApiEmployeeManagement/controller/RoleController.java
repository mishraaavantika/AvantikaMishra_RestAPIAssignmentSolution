package com.greatLearning.ApiEmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.ApiEmployeeManagement.entity.Roles;
import com.greatLearning.ApiEmployeeManagement.service.RoleServiceImpl;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleServiceImpl roleService;
	
	@PostMapping("/addRole")
	public void addRole(@RequestBody Roles role) {
		roleService.addRole(role);
	}
}
