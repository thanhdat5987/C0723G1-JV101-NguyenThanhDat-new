package de_mo.on_luyen;

import java.util.Scanner;

public class luyen_tap_2 {
    public static void main(String[] args) {
        int choice =-1;
        while (choice!=3){
            System.out.println("Menu");
            System.out.println("Enter your choice");
            System.out.println("1. Draw triangle");
            System.out.println("2. Draw circle");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    drawRectangle();
                    break;
                case 2:
                    drawTriangle();
                    break;
                case 3:
                    System.exit(3);
                default:
                    System.out.println("no choice!");
            }
        }

    }

    public static void drawRectangle() {
        System.out.println("hello");
    }

    public static void drawTriangle() {
        System.out.println("hi");
    }
}
