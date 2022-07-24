package com.greatLearning.ApiEmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.ApiEmployeeManagement.dao.RoleRepository;
import com.greatLearning.ApiEmployeeManagement.entity.Roles;

@Service
public class RoleServiceImpl {
	
	@Autowired
	private RoleRepository roleRepository;

	public void addRole(Roles role) {
		roleRepository.save(role);
		
	}

}
