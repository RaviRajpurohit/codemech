package com.codemech.service;

import com.codemech.model.Employee;

public interface IEmployeeService {

    Employee get(int id);

    int add(Employee employee);

    Employee remove(int id);

    Employee update(int id, Employee employee);

    Iterable<Employee> getAll();
}
