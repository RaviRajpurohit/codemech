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

import com.codemech.model.Department;
import com.codemech.service.IDepartmentService;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

	@Autowired
	public IDepartmentService departmentService;

	@GetMapping(path = "/{id}")
	public Department get(@PathVariable int id) {
		if (id < 0)
			throw new IllegalArgumentException("Department ID must be positive integer");
		return departmentService.get(id);
	}

	@GetMapping
	public Iterable<Department> getAll() {
		return departmentService.getAll();
	}

	@PostMapping
	public int create(@RequestBody Department Department) {
		if (Department.getId() > 0) {
			throw new IllegalArgumentException("New Department must not contain any id.");
		}
		return departmentService.add(Department);
	}

	@DeleteMapping(path = "/{id}")
	public Department delete(@PathVariable int id) {
		if (id < 0)
			throw new IllegalArgumentException("Department ID must be positive integer");
		return departmentService.remove(id);
	}

	@PutMapping(path = "/{id}")
	public Department update(@PathVariable int id, @RequestBody Department department) {
		return departmentService.update(id, department);
	}

}
