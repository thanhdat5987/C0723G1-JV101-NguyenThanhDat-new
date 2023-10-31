package com.example.student_management.repository;

import com.example.student_management.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
}
