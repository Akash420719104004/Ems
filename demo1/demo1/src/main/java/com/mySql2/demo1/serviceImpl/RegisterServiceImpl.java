package com.mySql2.demo1.serviceImpl;
import com.mySql2.demo1.model.dtos.RegisterDto;
import com.mySql2.demo1.model.RegisterUser;
import com.mySql2.demo1.repository.RegisterRepository;
import com.mySql2.demo1.responses.SuccessResponse;
import com.mySql2.demo1.serviceImpl.service.RegisterService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterRepository registerRepository;
    @Override
    public SuccessResponse<Object> register(RegisterDto registerDto) throws MessagingException, IOException {
        SuccessResponse<Object>response=new SuccessResponse<>();
        RegisterUser registerUser;
        registerRepository.findByMobileNo(registerDto.getMobileNo()).ifPresent(user->{
          throw new RuntimeException("MobileNO Already Exists");
        });
        if(registerDto.getId()!=null&&registerDto.getId()!=0){
           registerUser = registerRepository.findById(registerDto.getId()).orElseThrow(()->new RuntimeException("User Not Found"));
           response.setStatusMessage("User Updated Successfully");
        }
        else{
             registerUser=new RegisterUser();
             response.setStatusMessage("User Added Successfully");
        }
        registerUser.setEmailId(registerDto.getEmailId());
        registerUser.setName(registerDto.getName());
        registerUser.setUserType(registerDto.getUserType());
        registerUser.setMobileNo(registerDto.getMobileNo());
        registerUser.setAddress(registerDto.getAddress());
        registerRepository.save(registerUser);
        return response;
    }
}