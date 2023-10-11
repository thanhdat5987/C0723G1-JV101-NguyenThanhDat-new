package bai_3.view;

import bai_3.controller.ElectricalBillController;
import bai_3.model.ElectricalBill;
import bai_3.service.IElectricalBillService;
import bai_3.util.Validation;

import java.util.List;
import java.util.Scanner;

public class ElectricalBillManagementView {
    private static final ElectricalBillController electricalBillController = new ElectricalBillController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        int choice = 0;
        while (choice != 3) {
            try {
                System.out.println("===Menu===");
                System.out.println("1.Add electrical Bill");
                System.out.println("2.Display electrical Bill");
                System.out.println("3.Exit");
                System.out.println("Please enter your choice");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addElectricalBill();
                        break;
                    case 2:
                        displayBills();
                        break;
                    case 3:
                        System.exit(3);
                    default:
                        System.out.println("Please enter number 1-3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }

        }
    }

    public static void addElectricalBill() {
        String billId;
        do {
            System.out.println("Please enter bill Id: ");
            billId = scanner.nextLine();
            if (Validation.checkRegexBillId(billId)) {
                if (!checkBillId(billId)) {
                    break;
                } else {
                    System.out.println("Bill Id has been exits");
                }
            } else {
                System.out.println("Please input following format MHD-xxxx , x is number 0-9");
            }
        } while (true);
        String customerName;
        do{
            System.out.println("Please enter customer name");
            customerName = scanner.nextLine();
            if(!customerName.isEmpty()){
                break;
            }else {
                System.out.println("Please enter customer name");
            }
        }while (true);

        String customerType;
        do {
            System.out.println("Please enter customer type:");
            customerType = scanner.nextLine();
            if (customerType.equals("sinh hoat") || customerType.equals("kinh doanh")){
                break;
            }else {
                System.out.println("Please enter sinh hoat or kinh doanh ");
            }
        } while (true);

        int targetConsumption;
        do {
            try {
                System.out.println("Please enter target Consumption, >0");
                targetConsumption = Integer.parseInt(scanner.nextLine());
                if (targetConsumption > 0) {
                    break;
                } else {
                    System.out.println("target Consumption must be >0");
                }
            } catch (NumberFormatException e) {
                System.out.println("please enter a number");
            }
        } while (true);
        ElectricalBill newBill = new ElectricalBill(billId, customerName, customerType, targetConsumption);
        electricalBillController.addBill(newBill);
    }

    public static void displayBills() {
        List<ElectricalBill> bills = electricalBillController.getAllBills();
        for (ElectricalBill bill : bills) {
            System.out.print(bill);
            System.out.println("   Total="+bill.getTargetConsumption()*2500);
        }
    }

    public static boolean checkBillId(String billId) {
        List<ElectricalBill> bills = electricalBillController.getAllBills();
        for (ElectricalBill bill : bills) {
            if (bill.getBillId().equals(billId)) {
                return true;
            }
        }
        return false;
    }
}
