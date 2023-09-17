package de_mo.mvc.studentManagementv2.service.impl;

import de_mo.mvc.studentManagementv1.model.Student;
import de_mo.mvc.studentManagementv1.repository.IStudentRepository;
import de_mo.mvc.studentManagementv1.repository.impl.StudentRepositoryImpl;
import de_mo.mvc.studentManagementv1.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public void createStudent(Student student) {
        if (student == null || student.getId() > 0) {
            return;
        }
        studentRepository.createStudent(student);
    }

    @Override
    public Student[] getStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public Student getStudentDetail(int id) {
        if(id<=0){
            return null;
        }

        return studentRepository.getStudentDetail(id);
    }

    @Override
    public void updateStudent(Student newStudent) {

    }

    @Override
    public void deleteStudent(int id) {

    }
}
