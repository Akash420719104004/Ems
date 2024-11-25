package com.mySql2.demo1.model.dtos;
import lombok.Data;
@Data
public class StudentDto1 {
    private Long id;
    private String name;
    private String studentId;
    private String password;
    private String departmentName;
    private String studentCity;
    private String createdAt;
    private String updatedAt;
    private String createdBy;
    private String updatedBy;
}
