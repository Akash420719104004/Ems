package com.mySql2.demo1.repository;
import com.mySql2.demo1.model.Student1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student1,Long> {
    @Query("SELECT m FROM Student1 m WHERE m.name = :name")
    Optional<Student1> findByName(String name);
}
