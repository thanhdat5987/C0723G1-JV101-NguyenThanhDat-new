package ss_15.bai_tap.illegal_triangle_exception;

import java.util.Scanner;

public class Triangle {
    private Scanner scanner = new Scanner(System.in);

    public void checkTriangle() {
        do {
            float a;
            float b;
            float c;
            System.out.println("Please edge a of the triangle: ");
            a = enterTriangleEdge();
            System.out.println("Please edge b of the triangle: ");
            b = enterTriangleEdge();
            System.out.println("Please edge c of the triangle: ");
            c = enterTriangleEdge();
            try {
                checkTriangleCondition(a, b, c);
                return;
            } catch (IllegalTriangleException e) {
                System.out.println("Exception: " + e.getMessage() + ", please enter a, b, c again");
            }
        } while (true);
    }

    public float enterTriangleEdge() {
        float edge;
        do {
            try {
                edge = Float.parseFloat(scanner.nextLine());
                checkEdgeGreaterThanZero(edge);
                return edge;
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input string, please enter again");
            } catch (IllegalTriangleException e) {
                System.out.println("Exception: " + e.getMessage() + ", please enter again");
            }
        } while (true);
    }

    public float checkEdgeGreaterThanZero(float edge) throws IllegalTriangleException {
        if (edge <= 0) {
            throw new IllegalTriangleException("The egle of Triangle must be greeter than 0");
        } else {
            return edge;
        }
    }

    public void checkTriangleCondition(float a, float b, float c) throws IllegalTriangleException {
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println(a + ", " + b + ", " + c + " is 3 edge of a Triangle");
        } else {
            throw new IllegalTriangleException("a, b, c must meet the condition:a + b > c && a + c > b && b + c > a ");
        }
    }
}
