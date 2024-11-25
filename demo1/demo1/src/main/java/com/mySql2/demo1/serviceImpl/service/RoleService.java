package com.mySql2.demo1.serviceImpl.service;

import com.mySql2.demo1.model.Role;
import com.mySql2.demo1.model.dtos.RoleDto;
import com.mySql2.demo1.repository.RoleRepository;
import com.mySql2.demo1.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public interface RoleService {
  public SuccessResponse<Object> addRole(RoleDto roleDto) ;
}
