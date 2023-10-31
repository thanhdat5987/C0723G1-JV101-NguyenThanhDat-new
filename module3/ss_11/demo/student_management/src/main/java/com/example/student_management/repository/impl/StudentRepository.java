package com.example.student_management.repository.impl;

import com.example.student_management.model.Student;
import com.example.student_management.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Dat", true, 4, 1));
        studentList.add(new Student(1, "Toai", true, 6, 1));
        studentList.add(new Student(1, "Quyen", true, 8, 1));
        studentList.add(new Student(1, "Hieu", true, 7, 1));
        studentList.add(new Student(1, "Giang", false, 9, 1));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
studentList.add(student);
    }
}
