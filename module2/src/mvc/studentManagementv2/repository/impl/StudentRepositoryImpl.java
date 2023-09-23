package mvc.studentManagementv2.repository.impl;


import mvc.studentManagementv2.model.Student;
import mvc.studentManagementv2.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
   private final List<Student> studentList = new ArrayList<Student>();
    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public Student editStudent(int index) {
        return studentList.get(index);
    }

    @Override
    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public Student getStudent(int index) {
        return studentList.get(index);
    }

    @Override
    public void deleteStudent(int index) {
        studentList.remove(index);
    }
}
