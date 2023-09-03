package ss_1.bai_tap.say_hello;

import java.util.Scanner;

public class SayHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name please:");
        String name = scanner.nextLine();
        System.out.println("Hello, nice to meet you " + name);
    }
}
