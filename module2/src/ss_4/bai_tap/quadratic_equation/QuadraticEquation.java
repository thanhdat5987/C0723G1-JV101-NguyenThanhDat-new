package ss_4.bai_tap.quadratic_equation;

import java.util.Scanner;

public class QuadraticEquation {
    double aCoefficient;
    double bCoefficient;
    double cCoefficient;

    public QuadraticEquation(double aCoefficient, double bCoefficient, double cCoefficient) {
        this.aCoefficient = aCoefficient;
        this.bCoefficient = bCoefficient;
        this.cCoefficient = cCoefficient;
    }

    public double getCoefficientA() {
        return this.aCoefficient;
    }

    public double getCoefficientB() {
        return this.bCoefficient;
    }

    public double getCoefficientC() {
        return this.cCoefficient;
    }

    public double getDiscriminant() {
        double delta;
        delta = getCoefficientB() * getCoefficientB() - 4 * getCoefficientA() * getCoefficientC();
        return delta;
    }

    public double getRoot1() {
        double root1;
        root1 = (-getCoefficientB() + Math.sqrt(getDiscriminant())) / (2 * getCoefficientA());
        return root1;
    }

    public double getRoot2() {
        double root2;
        root2 = (-getCoefficientB() - Math.sqrt(getDiscriminant())) / (2 * getCoefficientA());
        return root2;
    }
}
