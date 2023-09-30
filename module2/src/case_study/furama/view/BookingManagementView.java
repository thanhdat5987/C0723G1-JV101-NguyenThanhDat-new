package case_study.furama.view;

import java.util.Scanner;

public class BookingManagementView {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayBookingManagementMenu() {
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
                        FuramaManagementView.displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public static void addNewBooking() {
    }

    public static void displayListBooking() {
    }

    public static void creatNewContract() {
    }

    public static void displayListContracts() {
    }

    public static void editContract() {
    }

}
