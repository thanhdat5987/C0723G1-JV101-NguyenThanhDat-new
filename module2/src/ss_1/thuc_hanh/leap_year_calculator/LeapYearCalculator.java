package ss_1.thuc_hanh.leap_year_calculator;

import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a year please: ");
        int year = scanner.nextInt();
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                System.out.println(year + " is a leap year");
            } else {
                if (year % 400 == 0) {
                    System.out.println(year + " is a leap year");
                } else {
                    System.out.println(year + " is not a leap year");
                }
            }
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}
