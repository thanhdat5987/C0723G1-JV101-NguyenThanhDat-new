package case_study.furama.view;

import java.util.Scanner;

public class FuramaManagementView {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
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
                        EmployeeManagementView.displayEmployeeManagementMenu();
                        break;
                    case 2:
                        CustomerManagementView.displayCustomerManagementMenu();
                        break;
                    case 3:
                        FacilityManagementView.displayFacilityManagementMenu();
                        break;
                    case 4:
                        BookingManagementView.displayBookingManagementMenu();
                        break;
                    case 5:
                        PromotionManagementView.displayPromotionManagementMenu();
                        break;
                    case 6:
                        System.exit(6);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

}

