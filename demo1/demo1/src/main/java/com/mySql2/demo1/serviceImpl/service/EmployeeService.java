package com.mySql2.demo1.serviceImpl.service;
import com.mySql2.demo1.model.Employee;
import com.mySql2.demo1.model.dtos.EmployeeDto;
import com.mySql2.demo1.model.dtos.EmployeeUpdateDto;
import com.mySql2.demo1.model.dtos.ResponseEmployeeDto;
import com.mySql2.demo1.responses.SuccessResponse;

public interface EmployeeService {
   // String addEmployee(EmployeeDto employeeDto);
  //  EmployeeResponseDto getmobileNoByName(String mobileNo);
    SuccessResponse<Object>addEmployees(EmployeeDto employeeDto);
    Employee updateEmployess(EmployeeUpdateDto employeeUpdateDto);
    ResponseEmployeeDto getEmployee(Long  id);

}
