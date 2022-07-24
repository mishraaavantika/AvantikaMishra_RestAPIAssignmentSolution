package com.greatLearning.ApiEmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatLearning.ApiEmployeeManagement.dao.EmployeeRepository;
import com.greatLearning.ApiEmployeeManagement.entity.Employee;
import com.greatLearning.ApiEmployeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> Employees = employeeRepository.findAll();
		return Employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(theId).get();
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);

	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {

		Employee employee = new Employee();
		employee.setFirstName(firstName);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher(firstName, ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");

		Example<Employee> example = Example.of(employee, exampleMatcher);

		return employeeRepository.findAll(example);
	}

	@Override
	public List<Employee> sortedByFirstName(Direction direction) {

		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}
}

