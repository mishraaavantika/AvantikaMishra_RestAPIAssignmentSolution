package com.greatLearning.ApiEmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.ApiEmployeeManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User getUserByUsername(String username);
}
