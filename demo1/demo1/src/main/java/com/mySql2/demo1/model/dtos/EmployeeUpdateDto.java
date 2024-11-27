package com.mySql2.demo1.model.dtos;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
public class EmployeeUpdateDto {
    private Long id;
    private List<String>userId;
    private String modifiedAt;
    private String modifiedBy;
}
