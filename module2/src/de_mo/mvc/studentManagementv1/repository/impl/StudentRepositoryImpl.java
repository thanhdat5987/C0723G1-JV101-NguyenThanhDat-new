package de_mo.mvc.studentManagementv1.repository.impl;

import de_mo.mvc.studentManagementv1.model.Student;
import de_mo.mvc.studentManagementv1.repository.IStudentRepository;

public class StudentRepositoryImpl implements IStudentRepository {
    private Student[] students = new Student[]{
            new Student(1, "Dat", "05/09/1987", "Male")
    };

    @Override
    public void createStudent(Student student) {
    Student[] newStudents = new Student[students.length+1];
    for(int i=0; i<students.length; i++){
        newStudents[i] = students[i];
    }
    student.setId(newStudents.length);
    newStudents[newStudents.length-1]= student;
    students = newStudents;
    }

    @Override
    public Student[] getStudents() {
        return students;
    }

    @Override
    public Student getStudentDetail(int id) {
        for(int i =0; i<students.length; i++){
            if(students[i].getId()==id) return students[i];
        }
        return null;
    }

    @Override
    public void updateStudent(Student newStudent) {

    }

    @Override
    public void deleteStudent(int id) {

    }
}
