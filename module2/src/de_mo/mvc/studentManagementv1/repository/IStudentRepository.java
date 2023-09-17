package de_mo.mvc.studentManagementv1.repository;

import de_mo.mvc.studentManagementv1.model.Student;

public interface IStudentRepository {
    void createStudent(Student student);
    Student[] getStudents();
    Student getStudentDetail(int id);
    void updateStudent(Student newStudent);
    void deleteStudent(int id);
}
