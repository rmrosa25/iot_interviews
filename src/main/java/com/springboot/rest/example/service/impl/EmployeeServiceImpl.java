package com.springboot.rest.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springboot.rest.example.dto.EmployeeDto;
import com.springboot.rest.example.dto.EmployeeExistingDto;
import com.springboot.rest.example.dto.EmployeeNewDto;
import com.springboot.rest.example.exception.ResourceNotFoundException;
import com.springboot.rest.example.model.Employee;
import com.springboot.rest.example.repository.EmployeeRepository;
import com.springboot.rest.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository EmployeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeNewDto EmployeeNewDto) {
        Employee Employee = new Employee();
        Employee.setId(EmployeeNewDto.getId());
        Employee.setEmployeeName(EmployeeNewDto.getEmployeeName());
        Employee.setDepartmentId(EmployeeNewDto.getDepartmentId());

        Employee = EmployeeRepository.save(Employee);

        EmployeeDto EmployeeDto = new EmployeeDto();
        EmployeeDto.setId(Employee.getId());
        EmployeeDto.setEmployeeName(Employee.getEmployeeName());
        EmployeeDto.setDepartmentId(Employee.getDepartmentId());
        return EmployeeDto;

    }

    @Override
    public EmployeeDto updateEmployee(EmployeeExistingDto EmployeeExistingDto) {
        Optional<Employee> EmployeeOpt = EmployeeRepository.findById(EmployeeExistingDto.getId());
        if (!EmployeeOpt.isPresent()) {
            throw new ResourceNotFoundException("Employee not found");
        }
        Employee Employee = EmployeeOpt.get();
        Employee.setEmployeeName(EmployeeExistingDto.getEmployeeName());
        Employee.setDepartmentId(EmployeeExistingDto.getDeparmentId());

        Employee = EmployeeRepository.save(Employee);

        EmployeeDto EmployeeDto = new EmployeeDto();
        EmployeeDto.setId(Employee.getId());
        EmployeeDto.setEmployeeName(Employee.getEmployeeName());
        EmployeeDto.setDepartmentId(Employee.getDepartmentId());
        
        return EmployeeDto;
    }

    @Override
    public void deleteEmployee(Integer EmployeeId) {
        if (EmployeeId == null) {
            throw new IllegalArgumentException("EmployeeId must not be null");
        }
        Optional<Employee> EmployeeOpt = EmployeeRepository.findById(EmployeeId);
        if (!EmployeeOpt.isPresent()) {
            throw new ResourceNotFoundException("Employee not found");
        }
        EmployeeRepository.deleteById(EmployeeId);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer EmployeeId) {
        if (EmployeeId == null) {
            throw new IllegalArgumentException("EmployeeId must not be null");
        }

        Optional<Employee> EmployeeOpt = EmployeeRepository.findById(EmployeeId);
        if (!EmployeeOpt.isPresent()) {
            throw new ResourceNotFoundException("Employee not found");
        }
        Employee Employee = EmployeeOpt.get();

        EmployeeDto EmployeeDto = new EmployeeDto();
        EmployeeDto.setId(Employee.getId());
        EmployeeDto.setEmployeeName(Employee.getEmployeeName());
        EmployeeDto.setDepartmentId(Employee.getDepartmentId());
       
        return EmployeeDto;
    }

    @Override
    public Page<EmployeeDto> getAllEmployees(Pageable pageable) {
        Page<Employee> EmployeesPage = EmployeeRepository.findAll(pageable);

        List<EmployeeDto> EmployeesDto = new ArrayList<>();
        Page<EmployeeDto> EmployeesDtoPage = new PageImpl<>(EmployeesDto, pageable, 0);

        if (EmployeesPage != null && !EmployeesPage.isEmpty()) {

            EmployeesPage.getContent().forEach(Employee -> {
                EmployeeDto EmployeeDto = new EmployeeDto();
                EmployeeDto.setId(Employee.getId());
                EmployeeDto.setEmployeeName(Employee.getEmployeeName());
                EmployeeDto.setDepartmentId(Employee.getDepartmentId());
                
                EmployeesDto.add(EmployeeDto);
            });
            EmployeesDtoPage =
                    new PageImpl<>(EmployeesDto, pageable, EmployeesPage.getTotalElements());
        }
        return EmployeesDtoPage;
    }

}