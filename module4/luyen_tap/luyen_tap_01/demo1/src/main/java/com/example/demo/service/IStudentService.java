package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById();
    void remove(int id);
    void save(Student student);
    Page<Student> findAndSearch(String name, Pageable pageable);
}
