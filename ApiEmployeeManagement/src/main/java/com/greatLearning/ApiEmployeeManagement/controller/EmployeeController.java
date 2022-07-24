package com.greatLearning.ApiEmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.ApiEmployeeManagement.entity.Employee;
import com.greatLearning.ApiEmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/list")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employees/{employeeId}

	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		return theEmployee;
	}

	// add mapping for POST /employees - add new employee

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theEmployee.setId(0);

		employeeService.save(theEmployee);

		return theEmployee;
	}

	// add mapping for PUT /employees - update existing employee

	@PutMapping("/update/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee theEmployee, @PathVariable int employeeId) {

		Employee tempEmployee = employeeService.findById(employeeId);

		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		tempEmployee.setFirstName(theEmployee.getFirstName());
		tempEmployee.setLastName(theEmployee.getLastName());
		tempEmployee.setEmail(theEmployee.getEmail());

		employeeService.save(tempEmployee);

		theEmployee.setId(employeeId);

		return theEmployee;
	}

	// add mapping for DELETE /employees/{employeeId} - delete employee

	@DeleteMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee tempEmployee = employeeService.findById(employeeId);

		// throw exception if null

		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		employeeService.deleteById(employeeId);

		return "Deleted employee id - " + employeeId;
	}

	@GetMapping("/sort")
	public List<Employee> getEmployeesCustomSortedByFirstName(@RequestParam("direction") Direction direction) {
		return employeeService.sortedByFirstName(direction);
	}

	@GetMapping("/search")
	public List<Employee> searchByFirstName(@RequestParam("firstName") String firstName) {

		return employeeService.searchByFirstName(firstName);
	}
}
