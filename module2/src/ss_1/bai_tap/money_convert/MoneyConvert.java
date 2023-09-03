package ss_1.bai_tap.money_convert;

import java.util.Scanner;

public class MoneyConvert {
    public static void main(String[] args) {
        double rate = 24000;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter USD amount: ");
        double usd = sc.nextDouble();
        System.out.print("VND amount is: "+ rate*usd);
    }
}
