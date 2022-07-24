package com.greatLearning.ApiEmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.ApiEmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
