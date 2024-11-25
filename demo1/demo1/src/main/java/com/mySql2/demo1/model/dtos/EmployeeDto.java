package com.mySql2.demo1.model.dtos;
import lombok.Data;
@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String mobileNo;
    private String createdBy;
    private String updatedBy;
    private String createdAt;
    private String updatedAt;
}
