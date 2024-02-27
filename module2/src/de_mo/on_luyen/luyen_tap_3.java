package de_mo.on_luyen;

import java.util.Scanner;

public class luyen_tap_3 {
    public static boolean checkPrime(int number) {
        boolean check = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                check = false;
                break;
            }
        }
        if (check) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter quantity of prime that you want to print");
            n = scanner.nextInt();
            if (n > 0) {
                break;
            } else {
                System.out.println("quantity must be greater than 0");
            }
        }
        while (true);
        int count = 0;
        for (int number = 2; count < n; number++) {
            if (checkPrime(number)) {
                System.out.println(number);
                count++;
            }
        }
    }
}
