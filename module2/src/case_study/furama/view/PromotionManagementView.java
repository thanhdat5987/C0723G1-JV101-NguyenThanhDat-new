package case_study.furama.view;

import java.util.Scanner;

public class PromotionManagementView {
    final static private Scanner scanner = new Scanner(System.in);
    public static void displayPromotionManagementMenu() {
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
                        FuramaManagementView.displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public static void displayListCustomersUseService() {
    }

    public static void displayListCustomersGetVoucher() {
    }
}
