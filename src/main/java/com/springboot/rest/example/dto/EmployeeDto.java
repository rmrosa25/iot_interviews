package com.springboot.rest.example.dto;

public class EmployeeDto {

    private Integer id;
    private String employeeName;
    private DepartmentDto department;
    
    

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public DepartmentDto getDepartment() {
        return this.department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }


}
