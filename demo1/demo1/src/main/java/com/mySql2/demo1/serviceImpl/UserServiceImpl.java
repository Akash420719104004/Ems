package com.mySql2.demo1.serviceImpl;

import com.mySql2.demo1.model.User;
import com.mySql2.demo1.model.dtos.UserDto;
import com.mySql2.demo1.repository.RoleRepository;
import com.mySql2.demo1.repository.UserDeviceIdRepository;
import com.mySql2.demo1.repository.UserRespositorty;
import com.mySql2.demo1.responses.SuccessResponse;
import com.mySql2.demo1.serviceImpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRespositorty userRespositorty;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserDeviceIdRepository userDeviceIdRepository;
    @Override
    public SuccessResponse<Object> addUser(UserDto userDto) {
        try {
            SuccessResponse<Object> response = new SuccessResponse<>();
            User user;
            userRespositorty.findByEmailId(userDto.getEmailId()).ifPresent(user1 -> {
                throw new RuntimeException("EmailId Already Exists");
            });
            if (userDto.getId() != null && userDto.getId() != 0) {
                user = userRespositorty.findById(userDto.getId()).orElseThrow(() -> new RuntimeException("User Not Found"));
                user.setModifiedAt(Timestamp.valueOf(LocalDateTime.now()));
                user.setModifiedBy(userDto.getModifiedBy());
                response.setStatusMessage("User Updated");
            } else {
                user = userRespositorty.findById(userDto.getId()).orElse(new User());
                user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
                user.setCreatedBy(userDto.getCreatedBy());
                response.setStatusMessage("User Added");
            }
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setAddress(userDto.getAddress());
            user.setUserName(userDto.getUserName());
            user.setGender(userDto.getGender());
            user.setExperience(userDto.getExperience());
            user.setDob(userDto.getDob());
            user.setActive(userDto.getActive());
            user.setDeletedFlag(userDto.getDeletedFlag());
            user.setPinCode(userDto.getPinCode());
            user.setRole(roleRepository.findById(userDto.getRoleId()).get());
            user.setUserDeviceId(userDeviceIdRepository.findById(userDto.getUserDeviceId()).get());
            user.setMobileNo(userDto.getMobileNo());
            user.setFcmToken(userDto.getFcmToken());
            user.setDetailsSaved(userDto.isDetailsSaved());
            userRespositorty.save(user);
            return response;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

}
