package com.springboot.rest.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.rest.example.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    public Page<Employee> findAll(Pageable pageable);
}