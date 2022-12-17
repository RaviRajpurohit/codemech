package com.codemech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemech.exception.EmployeeNotFoundException;
import com.codemech.model.Employee;
import com.codemech.repository.IEmployeeRepository;
import com.codemech.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee get(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee record found for given ID."));
	}

	@Override
	public int add(Employee employee) {
		return employeeRepository.save(employee).getId();
	}

	@Override
	public Employee remove(int id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee record found for given ID."));
		employeeRepository.deleteById(id);
		return employee;
	}

	@Override
	public Employee update(int id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee record found for given employee's ID."));
		employee.setId(id);
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Iterable<Employee> getAll() {
		return employeeRepository.findAll();
	}
}
