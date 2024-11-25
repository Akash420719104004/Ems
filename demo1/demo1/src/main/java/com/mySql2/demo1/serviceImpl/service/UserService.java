package com.mySql2.demo1.serviceImpl.service;

import com.mySql2.demo1.model.dtos.UserDto;
import com.mySql2.demo1.responses.SuccessResponse;

public interface UserService {
    SuccessResponse<Object> addUser(UserDto userDto);
}
