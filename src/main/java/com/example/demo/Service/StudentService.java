package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Student;

public interface StudentService {
    Student insertStudent(Student st);
    List<Student> getAllStudents();
    Optional<Student> getOneStudent(Long id);
    void deleteStudent(long id);
}