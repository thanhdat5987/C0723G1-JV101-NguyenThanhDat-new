package ss_2.bai_tap.list_prime;

import java.util.Scanner;

public class ListPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the quantity of prime: ");
            n = scanner.nextInt();
            if (n > 0) {
                break;
            } else {
                System.out.println("Quantity must be greater than 0");
            }
        } while (true);
        System.out.println("List first " + n + " Prime is: ");
        int count = 0, number = 2;
        while (count < n) {
            if (checkPrime(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }

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
}



