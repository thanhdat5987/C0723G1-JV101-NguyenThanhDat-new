package com.example.student_management.service.impl;

import com.example.student_management.model.Student;
import com.example.student_management.repository.IStudentRepository;
import com.example.student_management.repository.impl.StudentRepository;
import com.example.student_management.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
