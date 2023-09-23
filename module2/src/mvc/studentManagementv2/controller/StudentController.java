package mvc.studentManagementv2.controller;

import mvc.studentManagementv2.model.Student;
import mvc.studentManagementv2.service.IStudentService;
import mvc.studentManagementv2.service.impl.StudentServiceImpl;

import java.util.List;

public class StudentController {
   private final IStudentService studentService = new StudentServiceImpl();
    public void addStudent(Student student) {
        studentService.addStudent(student);
    }


    public Student editStudent(int index) {
        return studentService.editStudent(index);
    }


    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }


    public Student getStudent(int index) {
        return studentService.getStudent(index);
    }


    public void deleteStudent(int index) {
        studentService.deleteStudent(index);
    }
}
