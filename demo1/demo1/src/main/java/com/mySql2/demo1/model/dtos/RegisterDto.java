package com.mySql2.demo1.model.dtos;

import lombok.Data;

@Data
public class RegisterDto {
    private Integer id;

    private String name;

    private String userType;

    private String emailId;

    private String mobileNo;

    private String address;

    private Boolean active;
}
