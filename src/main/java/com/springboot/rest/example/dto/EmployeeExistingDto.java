package com.springboot.rest.example.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeExistingDto {

    @NotNull(message = "id cannot be empty")
    private Integer id;
    @NotNull(message = "employeeName cannot be empty")
    @Size(min = 2, max = 30,
            message = "employeeName must be atleast of 2 letters and not more then 100 letters")
    private String employeeName;
    private Integer deparmentId;

    
    

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
     * @return Integer return the deparmentId
     */
    public Integer getDeparmentId() {
        return deparmentId;
    }

    /**
     * @param deparmentId the deparmentId to set
     */
    public void setDeparmentId(Integer deparmentId) {
        this.deparmentId = deparmentId;
    }

}
