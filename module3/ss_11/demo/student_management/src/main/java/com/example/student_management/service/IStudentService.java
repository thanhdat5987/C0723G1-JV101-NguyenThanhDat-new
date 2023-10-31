package com.example.student_management.service;

import com.example.student_management.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
}
