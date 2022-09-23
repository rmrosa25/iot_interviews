package com.springboot.rest.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.springboot.rest.example.dto.EmployeeDto;
import com.springboot.rest.example.dto.EmployeeExistingDto;
import com.springboot.rest.example.dto.EmployeeNewDto;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeNewDto EmployeeNewDto);

    EmployeeDto updateEmployee(EmployeeExistingDto EmployeeExistingDto);

    void deleteEmployee(Integer EmployeeId);

    EmployeeDto getEmployeeById(Integer EmployeeId);

    Page<EmployeeDto> getAllEmployees(Pageable pageable);
}