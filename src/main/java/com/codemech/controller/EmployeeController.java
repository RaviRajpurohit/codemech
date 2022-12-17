package com.codemech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemech.model.Employee;
import com.codemech.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping(path = "/{id}")
	public Employee get(@PathVariable int id) {
		if (id < 0)
			throw new IllegalArgumentException("Employee ID must be positive integer");
		return employeeService.get(id);
	}

	@GetMapping
	public Iterable<Employee> getAll() {
		return employeeService.getAll();
	}

	@PostMapping
	public int create(@RequestBody Employee employee) {
		if (employee.getId() > 0) {
			throw new IllegalArgumentException("New Employee must not contain any id.");
		}
		return employeeService.add(employee);
	}

	@DeleteMapping(path = "/{id}")
	public Employee delete(@PathVariable int id) {
		if (id < 0)
			throw new IllegalArgumentException("Employee ID must be positive integer");
		return employeeService.remove(id);
	}

	@PutMapping(path = "/{id}")
	public Employee update(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.update(id, employee);
	}

}