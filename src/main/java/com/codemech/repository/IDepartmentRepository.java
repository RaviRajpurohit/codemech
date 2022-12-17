package com.codemech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codemech.model.Department;

@Repository
public interface IDepartmentRepository extends CrudRepository<Department, Integer> {

}
