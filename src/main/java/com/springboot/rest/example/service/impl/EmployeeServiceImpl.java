package com.springboot.rest.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.rest.example.dto.DepartmentDto;
import com.springboot.rest.example.dto.EmployeeDto;
import com.springboot.rest.example.dto.EmployeeExistingDto;
import com.springboot.rest.example.dto.EmployeeNewDto;
import com.springboot.rest.example.exception.ResourceNotFoundException;
import com.springboot.rest.example.model.Employee;
import com.springboot.rest.example.repository.EmployeeRepository;
import com.springboot.rest.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
        ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public EmployeeDto addEmployee(EmployeeNewDto employeeNewDto) {
        Employee employee = modelMapper.map(employeeNewDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);  
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeExistingDto EmployeeExistingDto) {
        Optional<Employee> EmployeeOpt = employeeRepository.findById(EmployeeExistingDto.getId());
        if (!EmployeeOpt.isPresent()) {
            throw new ResourceNotFoundException("Employee not found");
        }
        Employee Employee = EmployeeOpt.get();
        Employee.setEmployeeName(EmployeeExistingDto.getEmployeeName());
        Employee.setDepartmentId(EmployeeExistingDto.getDeparmentId());

        Employee savedEmployee = employeeRepository.save(Employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        if (employeeId == null) {
            throw new IllegalArgumentException("EmployeeId must not be null");
        }
        Optional<Employee> EmployeeOpt = employeeRepository.findById(employeeId);
        if (!EmployeeOpt.isPresent()) {
            throw new ResourceNotFoundException("Employee not found");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer employeeId) {
        if (employeeId == null) {
            throw new IllegalArgumentException("EmployeeId must not be null");
        }

        Optional<Employee> EmployeeOpt = employeeRepository.findById(employeeId);
        if (!EmployeeOpt.isPresent()) {
            throw new ResourceNotFoundException("Employee not found");
        }

        return modelMapper.map(EmployeeOpt.get(), EmployeeDto.class);
    }

    @Override
    public Page<EmployeeDto> getAllEmployees(Pageable pageable) {
        Page<Employee> EmployeesPage = employeeRepository.findAll(pageable);

        List<EmployeeDto> EmployeesDto = new ArrayList<>();
        Page<EmployeeDto> EmployeesDtoPage = new PageImpl<>(EmployeesDto, pageable, 0);

        if (EmployeesPage != null && !EmployeesPage.isEmpty()) {

            EmployeesPage.getContent().forEach(employee -> {
                EmployeesDto.add(modelMapper.map(employee, EmployeeDto.class));

            });
            EmployeesDtoPage = new PageImpl<>(EmployeesDto, pageable, EmployeesPage.getTotalElements());
        }
        return EmployeesDtoPage;
    }

}