package case_study.furama.view;

import java.util.Scanner;

public class CustomerManagementView {
    private static Scanner scanner = new Scanner(System.in);
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
                        FuramaManagementView.displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public static void displayListCustomers() {
    }

    public static void addNewCustomer() {
    }

    public static void editCustomer() {
    }

    public static void deleteCustomer() {
    }

    public static void searchByNameCustomer() {
    }
}
