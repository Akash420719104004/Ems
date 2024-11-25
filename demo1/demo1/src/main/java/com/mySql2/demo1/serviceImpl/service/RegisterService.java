package com.mySql2.demo1.serviceImpl.service;

import com.mySql2.demo1.model.dtos.RegisterDto;
import com.mySql2.demo1.responses.SuccessResponse;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface RegisterService {
    public SuccessResponse<Object>register(RegisterDto registerDto) throws MessagingException, IOException;
//    public SuccessResponse<Object>get(Integer userId);
//    public SuccessResponse<Object>getAllUser();
}
