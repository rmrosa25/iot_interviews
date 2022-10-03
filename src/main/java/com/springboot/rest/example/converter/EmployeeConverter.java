package com.springboot.rest.example.converter;

import java.util.Objects;

import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.springboot.rest.example.dto.DepartmentDto;
import com.springboot.rest.example.dto.EmployeeDto;
import com.springboot.rest.example.model.Employee;

@Component
public class EmployeeConverter implements ConditionalConverter<Employee, EmployeeDto> {
    @Override
    public EmployeeDto convert(MappingContext<Employee, EmployeeDto> context) {
        Employee employee = context.getSource();
        EmployeeDto employeeDto = Objects.nonNull(context.getDestination()) ? context.getDestination() : new EmployeeDto();
        if (employee != null) {
            employeeDto.setId(employee.getId());
            employeeDto.setEmployeeName(employee.getEmployeeName());
            if(employee.getDepartment() != null) {
                DepartmentDto departmentDto = new DepartmentDto();
                departmentDto.setDepartmentName(employee.getDepartment().getDepartmentName());
                departmentDto.setId(employee.getDepartment().getId());
                employeeDto.setDepartment(departmentDto);
            }
        }

        return employeeDto;
    }

    @Override
    public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
        if (sourceType == Employee.class && destinationType == EmployeeDto.class) {
            return MatchResult.FULL;
        }

        if (destinationType == EmployeeDto.class) {
            return MatchResult.PARTIAL;
        }

        return MatchResult.NONE;
    }

}
