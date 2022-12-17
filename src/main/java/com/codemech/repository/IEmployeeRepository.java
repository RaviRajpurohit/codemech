package com.codemech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codemech.model.Employee;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}
