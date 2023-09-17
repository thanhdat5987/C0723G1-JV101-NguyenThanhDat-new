package de_mo.mvc.studentManagementv2.view;

import de_mo.mvc.studentManagementv1.controller.StudentController;
import de_mo.mvc.studentManagementv1.model.Student;

import java.util.Scanner;

public class StudentManagementView {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentController studentController = new StudentController();

    public int inputOtion() {
        int option = 0;
        do {
            showStudentManagerView();
            System.out.println("Please select feature: ");
            option = Integer.parseInt(scanner.nextLine());
        } while (option <= 0 || option > 4);
        return option;
    }

    public void render() {
        while (true) {
            handleStudentManagementOption(inputOtion());
        }
    }

    public void handleStudentManagementOption(int option) {
        switch (option) {
            case 1:
                //show students
                Student[] students = studentController.getStudents();
                for (Student student : students) {
                    System.out.println(student);
                }
                break;
            case 2:
                //show student detail information
                System.out.println("Please input student id");
                int id = Integer.parseInt(scanner.nextLine());
                Student student = studentController.getStudentDetail(id);
                if (student == null) {
                    System.out.println("Not found student");
                } else {
                    System.out.println(student);
                }
                break;
            case 3:
                //Create student
                System.out.println("Input student name");
                String name = scanner.nextLine();
                System.out.println("Input studnet dateOfBirth: ");
                String dateofBirth = scanner.nextLine();
                System.out.println("Input student gender: ");
                String gender = scanner.nextLine();
                Student newStudent = new Student(name, dateofBirth, gender);
                studentController.createStudent(newStudent);
                break;
            case 4:
                System.exit(1);
            default:
                break;
        }
    }

    public void showStudentManagerView() {
        System.out.println("===Student manager tools===");
        System.out.println("1. Show students");
        System.out.println("2. Show student detail information");
        System.out.println("3. Create new student");
        System.out.println("4. Exit application");
    }
}
