package com.mySql2.demo1.repository;
import com.mySql2.demo1.model.Employee;
import com.mySql2.demo1.responseDtos.EmployeeResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    EmployeeResponseDto findByMobileNo( String user);
    @Query("SELECT e FROM Employee e WHERE e.name = :name AND e.mobileNo = :mobileNo")
    Optional<Employee> findByEmailAndMobile(String mobileNo, String name);
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")

    List<Employee> findBysearch(String name);
}
