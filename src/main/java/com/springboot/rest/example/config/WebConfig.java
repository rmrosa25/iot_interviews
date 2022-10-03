package com.springboot.rest.example.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.rest.example.converter.EmployeeConverter;
import com.springboot.rest.example.dto.EmployeeDto;
import com.springboot.rest.example.model.Employee;

@Configuration
public class WebConfig {
    @Bean
    public ModelMapper modelMapper(EmployeeConverter employeeConverter) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.createTypeMap(Employee.class, EmployeeDto.class).setConverter(employeeConverter);
        return modelMapper;
    }
}
