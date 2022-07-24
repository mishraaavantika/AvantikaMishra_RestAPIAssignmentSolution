package com.greatLearning.ApiEmployeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatLearning.ApiEmployeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

	public List<Employee> searchByFirstName(String firstName);

	public List<Employee> sortedByFirstName(Direction direction);
}
