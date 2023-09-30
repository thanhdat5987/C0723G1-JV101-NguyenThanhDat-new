package case_study.furama.view;

import case_study.furama.controller.EmployeeController;
import case_study.furama.model.Employee;

import java.util.List;
import java.util.Scanner;


public class EmployeeManagementView {
    private static Scanner scanner = new Scanner(System.in);
    static EmployeeController employeeController = new EmployeeController();

    public static void displayEmployeeManagementMenu() {
        int employeeManagementChoice = 0;
        while (employeeManagementChoice != 6) {
            try {
                System.out.println("===Employee Management Menu===");
                System.out.println("1.Display list employees");
                System.out.println("2.Add new employee");
                System.out.println("3.Edit employee");
                System.out.println("4.Delete employee");
                System.out.println("5.Search by name employee");
                System.out.println("6.Return main Menu");
                System.out.println("Please enter your choose");
                employeeManagementChoice = Integer.parseInt(scanner.nextLine());
                switch (employeeManagementChoice) {
                    case 1:
                        displayListEmployees();
                        break;
                    case 2:
                        addNewEmployee();
                        break;
                    case 3:
                        editEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        searchByNameEmployee();
                        break;
                    case 6:
                        FuramaManagementView.displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }

        }
    }

    public static void displayListEmployees() {
        List<Employee> employees = employeeController.display();
        for(Employee employee: employees){
            System.out.println(employee);
        }
    }

    public static void addNewEmployee() {
        String newEmployeeId;
        do {
            try {
                System.out.println("Input product Id");
                newEmployeeId = scanner.nextLine();
                if (!checkId(newEmployeeId)) {
                    break;
                }
                System.out.println("Id has been exist");
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input string, please enter again");
            }
        } while (true);
        System.out.println("Enter name of Employee:");
        String newName = scanner.nextLine();
        System.out.println("Enter dateOfBirth of Employee:");
        String newDateOfBirth = scanner.nextLine();
        System.out.println("Enter Gender of Employee:");
        String newGender = scanner.nextLine();
        System.out.println("Enter Citizen Id of Employee:");
        String newCitizenId = scanner.nextLine();
        System.out.println("Enter Phone number of Employee:");
        String newPhoneNumber = scanner.nextLine();
        System.out.println("Enter Email of Employee:");
        String newEmail = scanner.nextLine();
        System.out.println("Enter Level of Employee: ");
        String newLevel = scanner.nextLine();
        System.out.println("Enter Position of Employee: ");
        String newPosition = scanner.nextLine();
        System.out.println("Enter salary of Employee: ");
        int newSalary = Integer.parseInt(scanner.nextLine());
        Employee newEmployee = new Employee(newEmployeeId, newName, newDateOfBirth, newGender, newCitizenId, newPhoneNumber, newEmail, newLevel, newPosition, newSalary);
        employeeController.add(newEmployee);
    }

    static boolean checkId(String employeeId) {
        List<Employee> employees = employeeController.display();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(employeeId)) {
                return true;
            }
        }
        return false;
    }

    public static void editEmployee() {
    }

    public static void deleteEmployee() {
    }

    public static void searchByNameEmployee() {
    }
}
