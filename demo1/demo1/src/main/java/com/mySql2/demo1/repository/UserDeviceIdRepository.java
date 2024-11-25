package com.mySql2.demo1.repository;

import com.mySql2.demo1.model.UserDeviceId;
import com.mySql2.demo1.serviceImpl.service.UserDeviceIdService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeviceIdRepository extends JpaRepository<UserDeviceId,Integer> {
}
