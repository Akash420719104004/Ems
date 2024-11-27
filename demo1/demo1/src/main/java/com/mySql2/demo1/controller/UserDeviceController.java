package com.mySql2.demo1.controller;
import com.mySql2.demo1.model.Employee;
import com.mySql2.demo1.model.dtos.EmployeeDto;
import com.mySql2.demo1.model.dtos.EmployeeUpdateDto;
import com.mySql2.demo1.model.dtos.ResponseEmployeeDto;
import com.mySql2.demo1.responses.SuccessResponse;
import com.mySql2.demo1.serviceImpl.service.EmployeeService;
import com.mySql2.demo1.serviceImpl.service.UserDeviceIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employees")
public class UserDeviceController {
    @Autowired
    UserDeviceIdService userDeviceIdService;
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/addEmployee")
    public SuccessResponse<Object> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployees(employeeDto);
    }
    @GetMapping("/getEmployee")
    public ResponseEmployeeDto getEmployee(@RequestParam Long id){
        return employeeService.getEmployee(id);
    }
}
