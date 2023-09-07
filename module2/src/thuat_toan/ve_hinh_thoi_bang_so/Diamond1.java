package thuat_toan.ve_hinh_thoi_bang_so;

import java.util.Scanner;

public class Diamond1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int count = 0;

        System.out.println("Enter number of Prime numbers: ");
        num = sc.nextInt();
        for (int i = 0; count < num; i++) {
            if (checkPrime(i)) {
                System.out.println(i);
                count++;
            }
        }

    }

    public static boolean checkPrime(int number) {
        int count = 0;
        boolean result = true;
        if (number < 2) {
            result = false;
        } else {
            for (int i = 1; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count++;
                }
                result = count < 2;
            }
        }
        return result;
    }
}
