package com.example.bai_thi.service.impl;


import com.example.bai_thi.model.Student;
import com.example.bai_thi.repository.IStudentRepository;
import com.example.bai_thi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Page<Student> findAndSearch(String name, Pageable pageable) {
        return studentRepository.search("%" + name + "%", pageable);
    }
}
