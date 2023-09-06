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
            boolean checkP = checkPrime(number);
            if (checkP) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }

    public static boolean checkPrime(int number) {
        int i = 2;
        boolean check = true;
        while (i <= number / 2) {
            if (number % i == 0) {
                check = false;
                break;
            }
            i++;
        }
        if (check) {
            return true;
        } else {
            return false;
        }
    }
}



