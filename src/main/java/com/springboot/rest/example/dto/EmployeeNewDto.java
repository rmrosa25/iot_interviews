package com.springboot.rest.example.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeNewDto {
    private Integer id;
    @NotNull(message = "employeeName cannot be empty")
    @Size(min = 2, max = 30,
            message = "employeeName must be atleast of 2 letters and not more then 100 letters")
    private String employeeName;
    private Integer departmentId;

    

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

    /**
     * @return Integer return the departmentId
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

}
