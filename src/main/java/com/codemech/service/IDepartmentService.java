package com.codemech.service;

import com.codemech.model.Department;

public interface IDepartmentService {

	Department get(int id);

	int add(Department department);

	Department remove(int id);

	Department update(int id, Department department);

	Iterable<Department> getAll();
}
