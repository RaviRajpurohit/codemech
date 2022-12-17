package com.codemech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemech.exception.DepartmentNotFoundException;
import com.codemech.exception.EmployeeNotFoundException;
import com.codemech.model.Department;
import com.codemech.repository.IDepartmentRepository;
import com.codemech.service.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	public IDepartmentRepository departmentRepository;

	@Override
	public Department get(int id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("No Department record found for given id."));
	}

	@Override
	public int add(Department department) {
		return departmentRepository.save(department).getId();
	}

	@Override
	public Department remove(int id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("No Department record found for given ID."));
		departmentRepository.deleteById(id);
		return department;
	}

	@Override
	public Department update(int id, Department department) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee record found for given employee's ID."));
		department.setId(id);
		departmentRepository.save(department);
		return department;
	}

	@Override
	public Iterable<Department> getAll() {
		return departmentRepository.findAll();
	}

}
