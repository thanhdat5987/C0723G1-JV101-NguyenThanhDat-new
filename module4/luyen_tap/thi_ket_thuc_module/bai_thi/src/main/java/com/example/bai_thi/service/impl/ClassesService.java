package com.example.bai_thi.service.impl;

import com.example.bai_thi.model.Classes;
import com.example.bai_thi.repository.IClassRepository;
import com.example.bai_thi.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService implements IClassService {
    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<Classes> findAllClass() {
        return classRepository.findAll();
    }
}
