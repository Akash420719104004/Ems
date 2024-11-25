package com.mySql2.demo1.controller;
import com.mySql2.demo1.model.dtos.EmployeeDto;
import com.mySql2.demo1.responses.SuccessResponse;
import com.mySql2.demo1.serviceImpl.service.EmployeeService;
import com.mySql2.demo1.serviceImpl.service.UserDeviceIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserDeviceController {
    @Autowired
    UserDeviceIdService userDeviceIdService;
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/addUserDeviceId")
    public SuccessResponse<Object> addUserDeviceId(com.mySql2.demo1.model.UserDeviceId userDeviceId) {
        SuccessResponse<Object>response=userDeviceIdService.addUserDeviceId(userDeviceId);
        return response;

    }
    @PostMapping("/addEmployee")
    public SuccessResponse<Object> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployees(employeeDto);
    }
}
