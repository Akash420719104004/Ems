package com.mySql2.demo1.serviceImpl;
import com.mySql2.demo1.model.dtos.StudentDto1;
import com.mySql2.demo1.model.Student1;
import com.mySql2.demo1.repository.StudentRepository;
import com.mySql2.demo1.serviceImpl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentDto1 studentDto1) {
        if (studentDto1.getId() == null) {
            Optional<Student1> savedStudent = studentRepository.findByName(studentDto1.getName());
            if (savedStudent.isPresent()) {
                throw new RuntimeException("Name Already Exists");
            }
        }

        try {
            Student1 student1 = (studentDto1.getId() != null)
                    ? studentRepository.findById(studentDto1.getId()).orElseThrow(() -> new RuntimeException("Student not found"))
                    : new Student1();
            student1.setName(studentDto1.getName());
            student1.setStudentId(studentDto1.getStudentId());
            student1.setPassword(studentDto1.getPassword());
            student1.setDepartmentName(studentDto1.getDepartmentName());
            student1.setStudentCity(studentDto1.getStudentCity());
            boolean isNewStudent = (student1.getId() == null);
            if (isNewStudent) {
                student1.setCreatedAt(String.valueOf(LocalDateTime.now()));
                if (studentDto1.getCreatedBy() != null && !studentDto1.getCreatedBy().isEmpty()) {
                    student1.setCreatedBy(studentDto1.getCreatedBy());
                }
            } else {
                student1.setUpdatedAt(String.valueOf(LocalDateTime.now()));
                student1.setUpdatedBy(studentDto1.getUpdatedBy());
            }
            studentRepository.save(student1);
            return isNewStudent ? "Student Added Successfully" : "Student Updated Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


