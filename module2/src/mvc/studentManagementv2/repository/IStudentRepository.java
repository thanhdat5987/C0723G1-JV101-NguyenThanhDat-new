package mvc.studentManagementv2.repository;

import mvc.studentManagementv2.model.Student;

import java.util.List;

public interface IStudentRepository {
    void addStudent(Student student);
    Student editStudent(int index);
    List<Student> getStudentList();
    Student getStudent(int index);
    void deleteStudent(int index);
}
