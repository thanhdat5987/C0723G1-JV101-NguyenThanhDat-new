package ss_4.bai_tap.quadratic_equation;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        double delta;
        delta = getB() * getB() - 4 * getA() * getC();
        return delta;
    }

    public double getRoot1() {
        double root1;
        root1 = (-getB() + Math.sqrt(getDiscriminant())) / (2 * getA());
        return root1;
    }

    public double getRoot2() {
        double root2;
        root2 = (-getB() - Math.sqrt(getDiscriminant())) / (2 * getA());
        return root2;
    }
}
