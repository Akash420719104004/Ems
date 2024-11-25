package com.mySql2.demo1.model.dtos;
import lombok.Data;
import java.sql.Timestamp;
@Data
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String gender;
    private Timestamp dob;
    private Double experience;
    private String address;
    private Integer pinCode;
    private String emailId;
    private String mobileNo;
    private Integer roleId;
    private String profilePic;
    private Boolean active;
    private Boolean deletedFlag;
    private Timestamp createdAt;
    private Integer createdBy;
    private Timestamp modifiedAt;
    private Integer modifiedBy;
    private boolean detailsSaved;
    private String fcmToken;
    private Integer userDeviceId;
}
