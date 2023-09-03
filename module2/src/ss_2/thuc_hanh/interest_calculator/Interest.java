package ss_2.thuc_hanh.interest_calculator;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter investment amount please!");
        double money = scanner.nextDouble();
        System.out.println("Enter number of months: ");
        int month = scanner.nextInt();
        System.out.println("Enter annual interest rate percentage");
        double interestRate = scanner.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += (money+totalInterest) * (interestRate / (12 * 100));
        }
        System.out.println("Total of Interest is: "+totalInterest);
    }
}
