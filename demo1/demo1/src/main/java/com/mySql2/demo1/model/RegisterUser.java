package com.mySql2.demo1.model;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "register")
@Schema(description = "Represents a user in the system")
public class RegisterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier of the user", example = "1")
    private Integer id;

    @Column(name = "name")
    @Schema(description = "First name of the user", example = "John")
    private String name;

    @Column(name = "user_type")
    @Schema(description = "First name of the user", example = "John")
    private String userType;

    @Column(name = "email_id")
    @Schema(description = "Encrypted email address of the user", example = "johndoe@example.com")
    private String emailId;

    @Column(name = "mobile_no")
    @Schema(description = "Encrypted mobile number of the user", example = "+1234567890")
    private String mobileNo;

    @Column(name = "address")
    @Schema(description = "Address of the user", example = "123 Main St, Springfield")
    private String address;

    @Column(name = "is_active")
    @Schema(description = "Indicates if the user account is active", example = "true")
    private Boolean active = true;
}
