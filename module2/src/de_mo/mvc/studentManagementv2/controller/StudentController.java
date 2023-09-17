package de_mo.mvc.studentManagementv2.controller;

import de_mo.mvc.studentManagementv1.model.Student;
import de_mo.mvc.studentManagementv1.service.IStudentService;
import de_mo.mvc.studentManagementv1.service.impl.StudentServiceImpl;

public class StudentController {
    private final IStudentService studentService = new StudentServiceImpl();
    public void createStudent(Student student){
        studentService.createStudent(student);
    }
    public Student[] getStudents(){return studentService.getStudents();}
    public Student getStudentDetail(int id){
        return studentService.getStudentDetail(id);
    }
}
