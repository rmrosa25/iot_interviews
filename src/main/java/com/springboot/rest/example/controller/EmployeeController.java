package com.springboot.rest.example.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.rest.example.dto.EmployeeDto;
import com.springboot.rest.example.dto.EmployeeExistingDto;
import com.springboot.rest.example.dto.EmployeeNewDto;
import com.springboot.rest.example.service.EmployeeService;

@RestController
@RequestMapping(path = "/Employees")
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;

    @PostMapping(path = "/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody  @Valid  EmployeeNewDto EmployeeNewDto) {
        EmployeeDto Employee = EmployeeService.addEmployee(EmployeeNewDto);
        return ResponseEntity.ok(Employee);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @RequestBody  @Valid  EmployeeExistingDto EmployeeExistingDto) {
        EmployeeDto Employee = EmployeeService.updateEmployee(EmployeeExistingDto);
        return ResponseEntity.ok(Employee);
    }

    @DeleteMapping(path = "/{EmployeeId}/delete")
    public void deleteEmployee(@PathVariable(name = "EmployeeId") Integer EmployeeId) {
        EmployeeService.deleteEmployee(EmployeeId);
    }

    @GetMapping(path = "/{EmployeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(
            @PathVariable(name = "EmployeeId") Integer EmployeeId) {
        EmployeeDto Employee = EmployeeService.getEmployeeById(EmployeeId);
        return ResponseEntity.ok(Employee);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Page<EmployeeDto>> getEmployees(@PageableDefault(page = 0,
            size = 30) @SortDefault.SortDefaults({@SortDefault(sort = "employee_name",
                    direction = Sort.Direction.DESC)}) Pageable pageable) {
        Page<EmployeeDto> Employees = EmployeeService.getAllEmployees(pageable);
        return ResponseEntity.ok(Employees);
    }

}