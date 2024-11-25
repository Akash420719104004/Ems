package com.mySql2.demo1.utils;

import com.mySql2.demo1.model.User;
import lombok.Data;

@Data
public class UserContextDto {
    private int id;
    private String userName;
    private String mobileNo;

    public static UserContextDto map(User user){
        UserContextDto userContextDTO = new UserContextDto();
        userContextDTO.setId(user.getId());
        userContextDTO.setUserName(user.getUserName());
        userContextDTO.setMobileNo(user.getMobileNo());
        return userContextDTO;
    }
}

