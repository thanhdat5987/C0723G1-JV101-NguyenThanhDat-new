package case_study.furama.view;

import case_study.furama.controller.CustomerController;
import case_study.furama.model.Customer;
import case_study.furama.model.Employee;
import case_study.furama.util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagementView {
    private static CustomerController customerController = new CustomerController();
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> indexList;

    public static void displayCustomerManagementMenu() {
        int customerManagementChoice = 0;
        while (customerManagementChoice != 6) {
            try {
                System.out.println("===Customer Management Menu===");
                System.out.println("1.Display list customers");
                System.out.println("2.Add new customer");
                System.out.println("3.Edit customer");
                System.out.println("4.Delete customer");
                System.out.println("5.Search by name customer");
                System.out.println("6.Return main Menu");
                System.out.println("Please enter your choose");
                customerManagementChoice = Integer.parseInt(scanner.nextLine());
                switch (customerManagementChoice) {
                    case 1:
                        displayListCustomers();
                        break;
                    case 2:
                        addNewCustomer();
                        break;
                    case 3:
                        editCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 5:
                        searchByNameCustomer();
                        break;
                    case 6:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public static void displayListCustomers() {
        List<Customer> customers = customerController.display();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public static void addNewCustomer() {
        String newCustomerId = checkNewCustomerId();
        String newName = Validation.enterPersonName();
        String newDateOfBirth = Validation.enterDateOfBirth();
        System.out.println("Enter Gender of Customer:");
        String newGender = scanner.nextLine();
        String newCitizenId = Validation.enterCitizenId();
        String newPhoneNumber = Validation.enterPhoneNumber();
        System.out.println("Enter Email of Customer:");
        String newEmail = scanner.nextLine();
        System.out.println("Enter type of Customer: ");
        String newCustomerType = scanner.nextLine();
        System.out.println("Enter address of Customer: ");
        String newAddress = scanner.nextLine();
        Customer newCustomer = new Customer(newCustomerId, newName, newDateOfBirth, newGender, newCitizenId, newPhoneNumber, newEmail, newCustomerType, newAddress);
        customerController.add(newCustomer);
    }

    static boolean checkId(String customerId) {
        List<Customer> customers = customerController.display();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    static String checkNewCustomerId() {
        String newCustomerId;
        do {
            newCustomerId = Validation.enterCustomerId();
            if (!checkId(newCustomerId)) {
                return newCustomerId;
            } else {
                System.out.println("Id has been exist, please enter again");
            }
        } while (true);
    }

    static String checkCustomerId() {
        String customerId;
        do {
            customerId = Validation.enterCustomerId();
            if (checkId(customerId)) {
                return customerId;
            } else {
                System.out.println("Id has not been exist, please enter again");
            }
        } while (true);
    }

    public static void editCustomer() {
        String editingCustomerId = checkCustomerId();
        int editingIndex = getIndexById(editingCustomerId);
        String editingName = Validation.enterPersonName();
        String editingDateOfBirth = Validation.enterDateOfBirth();
        System.out.println("Re-Enter Gender of Customer:");
        String editingGender = scanner.nextLine();
        String editingCitizenId = Validation.enterCitizenId();
        String editingPhoneNumber = Validation.enterPhoneNumber();
        System.out.println("Re-Enter Email of Employee:");
        String editingEmail = scanner.nextLine();
        System.out.println("Re-Enter Type of Customer: ");
        String editingCustomerType = scanner.nextLine();
        System.out.println("Re-Enter Address of Customer: ");
        String editingAddress = scanner.nextLine();
        Customer editingEmployee = new Customer(editingCustomerId, editingName, editingDateOfBirth, editingGender, editingCitizenId, editingPhoneNumber, editingEmail, editingCustomerType, editingAddress);
        customerController.editPerson(editingIndex, editingEmployee);
    }

    static int getIndexById(String customerId) {
        List<Customer> customers = customerController.display();
        int findingId = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId().equals(customerId)) {
                findingId = i;
            }
        }
        return findingId;
    }

    public static void deleteCustomer() {
        String deletingCustomerId = checkCustomerId();
        customerController.deletePerson(getIndexById(deletingCustomerId));
        System.out.println("Delete successfully!");
    }

    public static void searchByNameCustomer() {
        List<Customer> customers = customerController.display();
        String searchingName = Validation.enterPersonName();
        getIndexByName(searchingName);
        if (!indexList.isEmpty()) {
            for (int i = 0; i < indexList.size(); i++) {
                System.out.println(customers.get(indexList.get(i)));
            }
        } else {
            System.out.println("Can't find the name " + searchingName);
        }
    }

    static void getIndexByName(String name) {
        List<Customer> customers = customerController.display();
        indexList = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                indexList.add(i);
            }
        }
    }
}
