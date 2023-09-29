package case_study.furama.view;

import java.util.Scanner;


public class EmployeeManagementView {
    private static Scanner scanner = new Scanner(System.in);
    //Employee Management
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

    }

    public static void addNewEmployee() {
    }

    public static void editEmployee() {
    }

    public static void deleteEmployee() {
    }

    public static void searchByNameEmployee() {
    }
}
