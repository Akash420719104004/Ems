package com.mySql2.demo1.repository;
import com.mySql2.demo1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String roleName);
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Optional<Object> findByName1(String roleName);
}
