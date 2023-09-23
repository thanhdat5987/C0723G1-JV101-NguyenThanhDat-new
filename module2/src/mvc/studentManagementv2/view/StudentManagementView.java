package mvc.studentManagementv2.view;

import mvc.studentManagementv2.model.Student;
import mvc.studentManagementv2.controller.StudentController;

import java.util.Scanner;

public class StudentManagementView {
    private Scanner scanner = new Scanner(System.in);
    private final StudentController studentController = new StudentController();

    public void displayMenu() {
        try {
            System.out.println("Please enter your choice:");
            System.out.println("1. Add student.");
            System.out.println("2. Display student list");
            System.out.println("3. Edit student");
            System.out.println("4. Delete student");
            System.out.println("5. Search student by Id");
            System.out.println("6. Exit program");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addStudent();
                    displayMenu();
                    break;
                case 2:
                    displayStudentList();
                    displayMenu();
                    break;
                case 3:
                    editStudent();
                    displayMenu();
                    break;
                case 4:
                    deleteStudent();
                    displayMenu();
                    break;
                case 5:
                    searchStudentById();
                    displayMenu();
                    break;
                case 6:
                    System.exit(5);
                default:
                    displayMenu();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter menu by number");
            displayMenu();
        }
    }


    public void addStudent() {
        int newId;
        do {
            try {
                System.out.println("Input student Id");
                newId = Integer.parseInt(scanner.nextLine());
                if (!checkId(newId)) {
                    break;
                }
                System.out.println("Id has been exist");
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input string, please enter again");
            }
        } while (true);
        System.out.println("Enter name:");
        String newName = scanner.nextLine();
        System.out.println("Enter birthday");
        String newDayOfBirth = scanner.nextLine();
        System.out.println("Enter class Name: ");
        String newClassName = scanner.nextLine();
        Student newStudent = new Student(newId, newName, newDayOfBirth, newClassName);
        studentController.getStudentList().add(newStudent);
    }

    public void displayStudentList() {
        for (int i = 0; i < studentController.getStudentList().size(); i++) {
            System.out.println(studentController.getStudentList().get(i));
        }
    }

    public void deleteStudent() {
        int deletingId;
        do {
            try {
                System.out.println("Enter student ID that you want to delete: ");
                deletingId = Integer.parseInt(scanner.nextLine());
                if (checkId(deletingId)) {
                    break;
                } else {
                    System.out.println("Id didn't exist, please enter Id again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Found Exception" + e.getMessage() + ", please enter Id again: ");
            }
        } while (true);
        studentController.deleteStudent(findIndexById(deletingId));
        System.out.println("Delete successfully");
    }

    public void editStudent() {

        int editingId;
        do {
            try {
                System.out.println("Enter Id of student that you want to edit: ");
                editingId = Integer.parseInt(scanner.nextLine());
                if (checkId(editingId)) {
                    break;
                } else {
                    System.out.println("Id is not exist, please enter again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Found exception: " + e.getMessage() + ", please enter id again");
            }
        } while (true);
        System.out.println("Please re-enter name: ");
        String editingName = scanner.nextLine();
        studentController.getStudent(findIndexById(editingId)).setName(editingName);
        System.out.println("Please re-enter day of birth");
        String editingBirthDay = scanner.nextLine();
        studentController.getStudent(findIndexById(editingId)).setDateOfBirth(editingBirthDay);
        System.out.println("Please re-enter class name");
        String editingClass = scanner.nextLine();
        studentController.getStudent(findIndexById(editingId)).setClassName(editingClass);
        displayStudentList();
    }

    public void searchStudentById() {
        int findingId;
        do {
            try{
                System.out.println("Enter student id that you want to find ");
                findingId = Integer.parseInt(scanner.nextLine());
                if (checkId(findingId)) {
                    System.out.println(studentController.getStudent(findIndexById(findingId)));
                    break;
                } else {
                    System.out.println("Can't find student");
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage()+"please re-enter id");
            }
        } while (true);

    }


    boolean checkId(int id) {
        for (int i = 0; i < studentController.getStudentList().size(); i++) {
            if (studentController.getStudentList().get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    int findIndexById(int id) {
        for (int i = 0; i < studentController.getStudentList().size(); i++) {
            if (studentController.getStudentList().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
