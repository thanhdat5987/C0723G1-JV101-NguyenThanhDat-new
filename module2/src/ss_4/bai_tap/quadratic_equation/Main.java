package ss_4.bai_tap.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Quadratic equation programming");
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        do {
            System.out.print("Please enter coefficient a, a must be greater than 0: ");
            a = scanner.nextDouble();
            if (a != 0) {
                break;
            } else {
                System.out.println("a must be greater than 0");
            }
        }
        while (true);
        System.out.print("Please enter coefficient b: ");
        b = scanner.nextDouble();
        System.out.print("Please enter coefficient c: ");
        c = scanner.nextDouble();
        QuadraticEquation myQuadraticEquation = new QuadraticEquation(a, b, c);
        if (myQuadraticEquation.getDiscriminant() > 0) {
            System.out.print("The equation has two roots: " + myQuadraticEquation.getRoot1() + " and " + myQuadraticEquation.getRoot2());
        } else if (myQuadraticEquation.getDiscriminant() == 0) {
            System.out.print("The equation has 1 root: " + myQuadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no root");
        }
    }
}
