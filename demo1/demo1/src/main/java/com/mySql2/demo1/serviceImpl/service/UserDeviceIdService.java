package com.mySql2.demo1.serviceImpl.service;

import com.mySql2.demo1.model.UserDeviceId;
import com.mySql2.demo1.repository.UserDeviceIdRepository;
import com.mySql2.demo1.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeviceIdService extends UserDeviceId {
    @Autowired
    UserDeviceIdRepository userDeviceIdRepository;
    public SuccessResponse<Object> addUserDeviceId(com.mySql2.demo1.model.UserDeviceId userDeviceId) {
        SuccessResponse<Object> response = new SuccessResponse<>();
        UserDeviceId userDeviceId1 = userDeviceIdRepository.findById(userDeviceId.getId()).orElse(new UserDeviceId());
        userDeviceId1 = userDeviceIdRepository.save(userDeviceId1);
        response.setStatusMessage("UserDeviceId Added Successfully");
        return response;
    }
}
