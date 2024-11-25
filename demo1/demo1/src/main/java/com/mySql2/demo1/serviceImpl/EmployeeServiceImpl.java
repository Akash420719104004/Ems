package com.mySql2.demo1.serviceImpl;
import com.mySql2.demo1.model.dtos.EmployeeDto;
import com.mySql2.demo1.model.Employee;
import com.mySql2.demo1.repository.EmployeeRepository;
import com.mySql2.demo1.responses.SuccessResponse;
import com.mySql2.demo1.serviceImpl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class  EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
//    @Override
//    public String addEmployee(EmployeeDto employeeDto) {
//        if (employeeDto.getId() == null) {
//            Optional<Employee> savedEmployee = employeeRepository.findByEmailAndMobile(employeeDto.getMobileNo(), employeeDto.getName());
//            if (savedEmployee.isPresent()) {
//                if (savedEmployee.get().getMobileNo().equals(employeeDto.getMobileNo())) {
//                    throw new RuntimeException("Mobile No Already Exits");
//                } else if (savedEmployee.get().getName().equals(employeeDto.getName())) {
//                    throw new RuntimeException("Name Already Exits");
//                }
//            }
//        }
//        try {
//            Employee employee = employeeRepository.findById(employeeDto.getId()).orElse(new Employee());
//            boolean isNewUser = employee.getId() == null;
//            employee.setName(employeeDto.getName());
//            employee.setMobileNo(employeeDto.getMobileNo());
//            if (isNewUser) {
//                employee.setCreatedAt(String.valueOf(LocalDateTime.now()));
//                if (employeeDto.getCreatedBy() != null && !employeeDto.getCreatedBy().isEmpty()) {
//                    employee.setCreatedBy(employeeDto.getCreatedBy());
//                }
//            } else {
//                employee.setUpdatedAt(String.valueOf(LocalDateTime.now()));
//                employee.setUpdatedBy(employeeDto.getUpdatedBy());
//            }
//            employeeRepository.save(employee);
//            return "Employee Added Successfully";
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public SuccessResponse<Object> addEmployees(EmployeeDto employeeDto) {
        try {
            SuccessResponse<Object> response = new SuccessResponse<>();
            Employee employee;
            Optional<Employee> existingEmployee = employeeRepository.findByEmailAndMobile(employeeDto.getMobileNo(), employeeDto.getName());
            if (existingEmployee.isPresent() && (employeeDto.getId() == null || !existingEmployee.get().getId().equals(employeeDto.getId()))) {
                throw new RuntimeException("Mobile number already exists for another employee.");
            }
            if (employeeDto.getId() != null && employeeDto.getId() != 0) {
                employee = employeeRepository.findById(employeeDto.getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
                employee.setUpdatedBy(employeeDto.getUpdatedBy());
                employee.setUpdatedAt(String.valueOf(LocalDateTime.now()));
                response.setStatusMessage("Employee Updated");
            } else {
                employee = new Employee();
                employee.setCreatedAt(String.valueOf(LocalDateTime.now()));
                employee.setCreatedBy(employeeDto.getCreatedBy());
                response.setStatusMessage("Employee Added");
            }
            employee.setMobileNo(employeeDto.getMobileNo());
            employee.setName(employeeDto.getName());
            employeeRepository.save(employee);
            return response;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error occurred while adding/updating employee: " + e.getMessage(), e);
        }
    }
}



    /*@Override
    public EmployeeResponseDto getmobileNoByName(String mobileNo) {
        EmployeeResponseDto employee = employeeRepository.findByMobileNo(mobileNo);
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            employeeResponseDto.setId(employee.getId());
            employeeResponseDto.setMobileNo(employee.getMobileNo());
            employeeResponseDto.setName(employee.getName());
            return employeeResponseDto;
        }
    }*/


