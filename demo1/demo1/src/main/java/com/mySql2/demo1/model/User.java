package com.mySql2.demo1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mySql2.demo1.utils.UserContextHolder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Optional;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier of the user", example = "1")
    private Integer id;

    @Column(name = "first_name")
    @Schema(description = "First name of the user", example = "John")
    private String firstName;

    @Column(name = "last_name")
    @Schema(description = "Last name of the user", example = "Doe")
    private String lastName;

    @Column(name = "user_name")
    @Schema(description = "Username of the user", example = "johndoe")
    private String userName;

    @Column(name = "gender")
    @Schema(description = "Gender of the user", example = "Male")
    private String gender;

    @Column(name = "dob")
    @Schema(description = "Date of birth of the user", example = "1990-01-01T00:00:00")
    private Timestamp dob;

    @Column(name = "experience")
    @Schema(description = "Years of experience of the user", example = "5.5")
    private Double experience;

    @Column(name = "address")
    @Schema(description = "Address of the user", example = "123 Main St, Springfield")
    private String address;

    @Column(name = "pincode")
    @Schema(description = "Pincode of the user's address", example = "123456")
    private Integer pinCode;

    @ColumnTransformer(
            read = "CONVERT(AES_DECRYPT(UNHEX(email_id),'1234') USING utf8)",
            write = "HEX(AES_ENCRYPT(?, '1234'))")
    @Column(name = "email_id")
    @Schema(description = "Encrypted email address of the user", example = "johndoe@example.com")
    private String emailId;

    @ColumnTransformer(
            read = "CONVERT(AES_DECRYPT(UNHEX(mobile_no),'1234') USING utf8)",
            write = "HEX(AES_ENCRYPT(?, '1234'))")
    @Column(name = "mobile_no")
    @Schema(description = "Encrypted mobile number of the user", example = "+1234567890")
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Schema(description = "Role assigned to the user")
    private Role role;

    @Column(name = "profile_pic")
    @Schema(description = "URL or path to the user's profile picture", example = "/images/profile/johndoe.jpg")
    private String profilePic;

    @Column(name = "is_active")
    @Schema(description = "Indicates if the user account is active", example = "true")
    private Boolean active;

    @Column(name = "deleted_flag")
    @Schema(description = "Indicates if the user account is deleted", example = "false")
    private Boolean deletedFlag;

    @Column(name = "created_at")
    @CreationTimestamp
    @Schema(description = "Timestamp when the user record was created", example = "2024-07-26T10:15:30")
    private Timestamp createdAt;

    @Column(name = "created_by")
    @Schema(description = "Identifier of the user who created this record", example = "1")
    private Integer createdBy;

    @Column(name = "modified_at")
    @UpdateTimestamp
    @Schema(description = "Timestamp when the user record was last modified", example = "2024-07-26T10:15:30")
    private Timestamp modifiedAt;

    @Column(name = "modified_by")
    @Schema(description = "Identifier of the user who last modified this record", example = "2")
    private Integer modifiedBy;

    @Column(name = "details_saved")
    @Schema(description = "Indicates if the details have been saved", example = "true")
    private boolean detailsSaved;

    @Column(name = "fcm_token")
    @Schema(description = "token used for push notifications", example = "jkdhfelkhfe")
    private String fcmToken;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private UserDeviceId userDeviceId;
    @ManyToOne
    private Employee employee;

    @PrePersist
    @PreUpdate
    void setAuditDetails() {
        Optional.ofNullable(UserContextHolder.getUserDto()).ifPresent(userContextDTO -> {
            this.setCreatedBy(userContextDTO.getId());
            this.setModifiedBy(userContextDTO.getId());
        });
    }

    protected void onCreate() {

    }

    public void setUserDeviceId(UserDeviceId userDeviceId) {
    }
}
