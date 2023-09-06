package ss_2.bai_tap.draw_shape;

import java.util.Scanner;

public class Shape {
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice please: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    drawRectangle();
                    break;
                case 2:
                    System.out.println("Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
                    drawSquareTriangle();
                    break;
                case 3:
                    System.out.println("Print isosceles triangle");
                    drawIsoscelesTriangle();
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void drawRectangle() {
        Scanner scanner = new Scanner(System.in);
        int width;
        int height;
        do {
            System.out.print("Enter rectangle's width: ");
            width = scanner.nextInt();
            if (width > 0) {
                break;
            } else {
                System.out.println("Rectangle's width must be greater than 0");
            }
        } while (true);
        do {
            System.out.print("Enter rectangle's height: ");
            height = scanner.nextInt();
            if (height > 0) {
                break;
            } else {
                System.out.println("Rectangle's height must ben greater than 0");
            }
        } while (true);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawSquareTriangle() {
        Scanner scanner = new Scanner(System.in);
        int edge;
        do {
            System.out.print("Enter the edge 's length: ");
            edge = scanner.nextInt();
            if (edge > 0) {
                break;
            } else {
                System.out.println("the edge length must be greater than 0");
            }
        } while (true);
        System.out.println("The corner is square at top-left:");
        for (int i = 0; i < edge; i++) {
            for (int j = edge - 1; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("The corner is square at top-right:");
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                if (i > j) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("The corner is square at bottom-left:");
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("The corner is square at bottom-right");
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                if (i < edge - j - 1) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static void drawIsoscelesTriangle() {
        Scanner scanner = new Scanner(System.in);
        int egle;
        do {
            System.out.print("Enter the egle length of Triangle: ");
            egle = scanner.nextInt();
            if (egle > 0) {
                break;
            } else {
                System.out.println("Egle length must be greater than 0");
            }
        } while (true);
        for (int i = 0; i < egle; i++) {
            for (int j = 0; j < egle - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
