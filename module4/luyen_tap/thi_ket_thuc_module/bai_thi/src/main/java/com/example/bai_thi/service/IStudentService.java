package com.example.bai_thi.service;

import com.example.bai_thi.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    void remove(int id);
    void save(Student student);
    Page<Student> findAndSearch(String name, Pageable pageable);
}
