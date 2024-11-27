package com.mySql2.demo1.controller;
import com.mySql2.demo1.model.dtos.StudentDto1;
import com.mySql2.demo1.serviceImpl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class Student1Controller {
    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    public ResponseEntity<String>addStudent(@RequestBody StudentDto1 studentDto1){
        String result=studentService.addStudent(studentDto1);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

}
