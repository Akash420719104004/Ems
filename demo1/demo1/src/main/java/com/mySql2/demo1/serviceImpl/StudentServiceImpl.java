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
        // Check if the student is new and if the name already exists
        if (studentDto1.getId() == null) { // New student, check for duplicate name
            Optional<Student1> savedStudent = studentRepository.findByName(studentDto1.getName());
            if (savedStudent.isPresent()) {
                throw new RuntimeException("Name Already Exists");
            }
        }

        try {
            // If the ID is present, fetch the student; otherwise, create a new one
            Student1 student1 = (studentDto1.getId() != null)
                    ? studentRepository.findById(studentDto1.getId()).orElseThrow(() -> new RuntimeException("Student not found"))
                    : new Student1();  // New student if ID is null

            // Set student fields
            student1.setName(studentDto1.getName());
            student1.setStudentId(studentDto1.getStudentId());
            student1.setPassword(studentDto1.getPassword());
            student1.setDepartmentName(studentDto1.getDepartmentName());
            student1.setStudentCity(studentDto1.getStudentCity());

            // Check if it's a new student or an update
            boolean isNewStudent = (student1.getId() == null);

            // Handle creation and update timestamps
            if (isNewStudent) {
                student1.setCreatedAt(String.valueOf(LocalDateTime.now()));
                if (studentDto1.getCreatedBy() != null && !studentDto1.getCreatedBy().isEmpty()) {
                    student1.setCreatedBy(studentDto1.getCreatedBy());
                }
            } else {
                student1.setUpdatedAt(String.valueOf(LocalDateTime.now()));
                student1.setUpdatedBy(studentDto1.getUpdatedBy());
            }

            // Save the student
            studentRepository.save(student1);

            // Return success message
            return isNewStudent ? "Student Added Successfully" : "Student Updated Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while adding/updating student: " + e.getMessage());
        }
    }
}


