package mvc.studentManagementv2.service.impl;

import mvc.studentManagementv2.model.Student;
import mvc.studentManagementv2.repository.IStudentRepository;
import mvc.studentManagementv2.repository.impl.StudentRepositoryImpl;
import mvc.studentManagementv2.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public void addStudent(Student student) {
studentRepository.addStudent(student);
    }

    @Override
    public Student editStudent(int index) {
        return studentRepository.editStudent(index);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.getStudentList();
    }

    @Override
    public Student getStudent(int index) {
        return studentRepository.getStudent(index);
    }

    @Override
    public void deleteStudent(int index) {
        studentRepository.deleteStudent(index);
    }
}
