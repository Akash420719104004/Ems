package com.mySql2.demo1.controller;
import com.mySql2.demo1.model.Employee;
import com.mySql2.demo1.model.dtos.EmployeeDto;
import com.mySql2.demo1.model.dtos.EmployeeUpdateDto;
import com.mySql2.demo1.model.dtos.ResponseEmployeeDto;
import com.mySql2.demo1.responses.SuccessResponse;
import com.mySql2.demo1.serviceImpl.service.EmployeeService;
import com.mySql2.demo1.serviceImpl.service.UserDeviceIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping("deleteEmployee")
    public ResponseEntity<String> deleteEmployee(Long id){
        String deleteEmployee= employeeService.deleteEmployee(id);
        return new ResponseEntity<>(deleteEmployee, HttpStatus.OK);
    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee> >getAllEmployee(@RequestParam String search){
       List<Employee> employee= employeeService.getAllEmployee(search);
       return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
