package mvc.studentManagementv2.service;

import mvc.studentManagementv2.model.Student;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    Student editStudent(int index);
    List<Student> getStudentList();
    Student getStudent(int index);
    void deleteStudent(int index);
}
