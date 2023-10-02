package case_study.furama.view;

import case_study.furama.controller.EmployeeController;
import case_study.furama.model.Employee;
import case_study.furama.util.Validation;

import java.util.ArrayList;
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
                        break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public static void displayListEmployees() {
        List<Employee> employees = employeeController.display();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void addNewEmployee() {
        String newEmployeeId = checkNewEmployeeId();
        String newName= Validation.enterPersonName();
        String newDateOfBirth = Validation.enterDateOfBirth();
        System.out.println("Enter Gender of Employee:");
        String newGender = scanner.nextLine();
        String newCitizenId =Validation.enterCitizenId();
        String newPhoneNumber = Validation.enterPhoneNumber();
        System.out.println("Enter Email of Employee:");
        String newEmail = scanner.nextLine();
        System.out.println("Enter Level of Employee: ");
        String newLevel = scanner.nextLine();
        System.out.println("Enter Position of Employee: ");
        String newPosition = scanner.nextLine();
        int newSalary = Validation.enterSalary();
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
    static String checkNewEmployeeId(){
        String newEmployeeId;
        do {
            newEmployeeId = Validation.enterEmployeeId();
            if (!checkId(newEmployeeId)) {
                return newEmployeeId;
            } else {
                System.out.println("Id has been exist, please enter again");
            }
        } while (true);
    }
    static String checkEmployeeId(){
        String employeeId;
        do {
            employeeId = Validation.enterEmployeeId();
            if (checkId(employeeId)) {
                return employeeId;
            } else {
                System.out.println("Id has not been exist, please enter again");
            }
        } while (true);
    }

    public static void editEmployee() {
        String editingEmployeeId = checkEmployeeId();
        int editingIndex = getIndexById(editingEmployeeId);
        String editingName= Validation.enterPersonName();
        String editingDateOfBirth = Validation.enterDateOfBirth();
        System.out.println("Re-Enter Gender of Employee:");
        String editingGender = scanner.nextLine();
        String editingCitizenId =Validation.enterCitizenId();
        String editingPhoneNumber = Validation.enterPhoneNumber();
        System.out.println("Re-Enter Email of Employee:");
        String editingEmail = scanner.nextLine();
        System.out.println("Re-Enter Level of Employee: ");
        String editingLevel = scanner.nextLine();
        System.out.println("Re-Enter Position of Employee: ");
        String editingPosition = scanner.nextLine();
        System.out.println("Re-Enter salary of Employee: ");
        int editingSalary = Validation.enterSalary();
        Employee editingEmployee = new Employee(editingEmployeeId,editingName,editingDateOfBirth,editingGender,editingCitizenId,editingPhoneNumber,editingEmail,editingLevel,editingPosition,editingSalary);
        employeeController.editPerson(editingIndex, editingEmployee);
    }

    public static void deleteEmployee() {
        String deletingEmployeeId = checkEmployeeId();
        employeeController.deletePerson(getIndexById(deletingEmployeeId));
    }
    static int getIndexById(String employeeId) {
        List<Employee> employees = employeeController.display();
        int findingId =-1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(employeeId)) {
                findingId =i;
            }
        }
        return findingId;
    }
    static List<Integer> getIndexByName(String name) {
        List<Employee> employees = employeeController.display();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                indexList.add(i);
            }
        }
        return indexList;
    }

    public static void searchByNameEmployee() {
        List<Employee> employees = employeeController.display();
        String searchingName = Validation.enterPersonName();
        List<Integer> indexList = getIndexByName(searchingName);
        for(int i=0; i<indexList.size();i++){
            System.out.println(employees.get(indexList.get(i)));
        }
    }
}
