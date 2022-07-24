package com.greatLearning.ApiEmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.ApiEmployeeManagement.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
