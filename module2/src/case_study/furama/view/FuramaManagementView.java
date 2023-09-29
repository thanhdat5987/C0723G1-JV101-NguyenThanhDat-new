package case_study.furama.view;

import java.util.Scanner;

public class FuramaManagementView {
    private Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        int choice = 0;
        while (choice != 6) {
            try {
                System.out.println("===Main Menu===");
                System.out.println("1.Employee Management");
                System.out.println("2.Customer Management");
                System.out.println("3.Facility Management ");
                System.out.println("4.Booking Management");
                System.out.println("5.Promotion Management");
                System.out.println("6.Exit");
                System.out.println("Please enter your choice");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayEmployeeManagementMenu();
                        break;
                    case 2:
                        displayCustomerManagementMenu();
                        break;
                    case 3:
                        displayFacilityManagementMenu();
                        break;
                    case 4:
                        displayBookingManagementMenu();
                        break;
                    case 5:
                        displayPromotionManagementMenu();
                        break;
                    case 6:
                        System.exit(6);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }

        }
    }

    //Employee Management
    public void displayEmployeeManagementMenu() {
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
                        displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }

        }
    }

    public void displayListEmployees() {
    }

    public void addNewEmployee() {
    }

    public void editEmployee() {
    }

    public void deleteEmployee() {
    }

    public void searchByNameEmployee() {
    }

    // Customer Management
    public void displayCustomerManagementMenu() {
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
                        displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public void displayListCustomers() {
    }

    public void addNewCustomer() {
    }

    public void editCustomer() {
    }

    public void deleteCustomer() {
    }

    public void searchByNameCustomer() {
    }

    public void displayFacilityManagementMenu() {
        int facilityManagementChoice = 0;
        while (facilityManagementChoice != 5) {
            try {
                System.out.println("===Facility Management Menu===");
                System.out.println("1.Display list facilities");
                System.out.println("2.Add new facility");
                System.out.println("3.Display list facilities maintenance");
                System.out.println("4.Delete facility");
                System.out.println("5.Return main Menu");
                System.out.println("Please enter your choose");
                facilityManagementChoice = Integer.parseInt(scanner.nextLine());
                switch (facilityManagementChoice) {
                    case 1:
                        displayListFacilities();
                        break;
                    case 2:
                        addNewFacility();
                        break;
                    case 3:
                        displayListFacilitiesMaintenance();
                        break;
                    case 4:
                        deleteFacility();
                        break;
                    case 5:
                        displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public void displayListFacilities() {
    }

    public void addNewFacility() {
    }

    public void displayListFacilitiesMaintenance() {
    }

    public void deleteFacility() {
    }

    public void displayBookingManagementMenu() {
        int bookingManagementChoice = 0;
        while (bookingManagementChoice != 6) {
            try {
                System.out.println("===Booking Management Menu===");
                System.out.println("1.Add new booking");
                System.out.println("2.Display list booking");
                System.out.println("3.Create new contract");
                System.out.println("4.Display list contracts");
                System.out.println("5.Edit contracts");
                System.out.println("6.Return main Menu");
                System.out.println("Please enter your choose");
                bookingManagementChoice = Integer.parseInt(scanner.nextLine());
                switch (bookingManagementChoice) {
                    case 1:
                        addNewBooking();
                        break;
                    case 2:
                        displayListBooking();
                        break;
                    case 3:
                        creatNewContract();
                        break;
                    case 4:
                        displayListContracts();
                        break;
                    case 5:
                        editContract();
                        break;
                    case 6:
                        displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public void addNewBooking() {
    }

    public void displayListBooking() {
    }

    public void creatNewContract() {
    }

    public void displayListContracts() {
    }

    public void editContract() {
    }

    public void displayPromotionManagementMenu() {
        int promotionManagementChoice = 0;
        while (promotionManagementChoice != 6) {
            try {
                System.out.println("===Promotion Management Menu===");
                System.out.println("1.Display list customers use service");
                System.out.println("2.Display list customers get voucher");
                System.out.println("3.Return main menu");
                promotionManagementChoice = Integer.parseInt(scanner.nextLine());
                switch (promotionManagementChoice) {
                    case 1:
                        displayListCustomersUseService();
                        break;
                    case 2:
                        displayListCustomersGetVoucher();
                        break;
                    case 3:
                        displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public void displayListCustomersUseService() {
    }

    public void displayListCustomersGetVoucher() {
    }
}

