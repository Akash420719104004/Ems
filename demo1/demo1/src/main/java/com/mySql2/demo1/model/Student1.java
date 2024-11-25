package com.mySql2.demo1.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="s12")
@Data
public class Student1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String studentId;
    private String password;
    private String departmentName;
    private String studentCity;
    private String createdBy;
    private String updatedBy;
    private String createdAt;
    private String updatedAt;
}
