package com.mySql2.demo1.repository;

import com.mySql2.demo1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespositorty extends JpaRepository<User,Integer> {
    Optional<Object> findByEmailId(String emailId);
}
