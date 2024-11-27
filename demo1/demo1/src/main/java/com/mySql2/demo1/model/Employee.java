package com.mySql2.demo1.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobileNo;
    private String position;
    private String department;
    private Double salary;
    private String createdBy;
    private String updatedBy;
    private String updatedAt;
    private String createdAt;
}
