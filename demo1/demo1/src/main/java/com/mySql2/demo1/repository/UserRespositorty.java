package com.mySql2.demo1.repository;

import com.mySql2.demo1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface UserRespositorty extends JpaRepository<User,Integer> {
    Optional<Object> findByEmailId(String emailId);
    List<User> findByIdIn(List<Long> ids);
}
