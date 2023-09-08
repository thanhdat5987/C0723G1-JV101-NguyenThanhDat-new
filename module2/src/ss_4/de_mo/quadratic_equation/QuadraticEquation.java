package ss_4.de_mo.quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public Double getDiscriminant(){
        return getB()*getB()-4*getA()*getC();
    }
    public Double getRoot1(){
        return ((-getB() +Math.sqrt(getDiscriminant()))/2*getA());
    }
    public Double getRoot2(){
        return ((-getB()-Math.sqrt(getDiscriminant()))/2*getA());
    }
}
