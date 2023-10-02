package case_study.furama.view;

import java.util.Scanner;

public class FacilityManagementView {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayFacilityManagementMenu() {
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
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public static void displayListFacilities() {
    }

    public static void addNewFacility() {
    }

    public static void displayListFacilitiesMaintenance() {
    }

    public static void deleteFacility() {
    }
}
