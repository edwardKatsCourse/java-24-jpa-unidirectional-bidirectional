package com.telran.jpabidirectionalunidirectional.repository;

import com.telran.jpabidirectionalunidirectional.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
