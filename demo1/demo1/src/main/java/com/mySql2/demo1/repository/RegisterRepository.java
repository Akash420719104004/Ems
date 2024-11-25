package com.mySql2.demo1.repository;

import com.mySql2.demo1.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterUser,Integer> {
   // @Query("SELECT e FROM Employee e WHERE e.mobileNo = : e.mobileNo = :mobileNo")
    Optional<Object> findByMobileNo(String mobileNo);
}
