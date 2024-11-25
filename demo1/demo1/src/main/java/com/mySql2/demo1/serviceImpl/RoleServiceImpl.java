package com.mySql2.demo1.serviceImpl;
import com.mySql2.demo1.model.Role;
import com.mySql2.demo1.model.dtos.RoleDto;
import com.mySql2.demo1.repository.RoleRepository;
import com.mySql2.demo1.responses.SuccessResponse;
import com.mySql2.demo1.serviceImpl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public SuccessResponse<Object> addRole(RoleDto roleDto) {
        SuccessResponse<Object>response=new SuccessResponse<>();
        Role registerUser;
        roleRepository.findByName1(roleDto.getRoleName()).ifPresent(role1->{
            throw new RuntimeException("Name Already Exists");
        });
        if(roleDto.getId()!=null&&roleDto.getId()!=0){
            registerUser = roleRepository.findById(roleDto.getId()).orElseThrow(()->new RuntimeException("User Not Found"));
            response.setStatusMessage("Role Updated Successfully");
        }
        else{
            registerUser=new Role();
          //  registerUser.setName(roleDto.getRoleName());
            response.setStatusMessage("Role Added");
        }
        registerUser.setName(roleDto.getRoleName());
        roleRepository.save(registerUser);
        return response;
    }
}
