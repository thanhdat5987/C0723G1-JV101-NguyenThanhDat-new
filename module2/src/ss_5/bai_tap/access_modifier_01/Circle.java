package ss_5.bai_tap.access_modifier_01;

public class Circle {
    private double radius = 1.0;
    private String color = "Red";

    Circle() {

    }

    Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return getRadius() * getRadius() * Math.PI;
    }

    private double getRadius1() {
        return radius;
    }

    private double getArea1() {
        return getRadius() * getRadius() * Math.PI;
    }

    public static void main(String[] args) {
        Circle myCircle = new Circle(5);
        myCircle.getRadius();
        myCircle.getArea();
        // Private method getRadius1 and Private method getArea1 can be use inside the class:
        Circle myCircle1 = new Circle(10);
        myCircle1.getRadius1();
        myCircle1.getArea1();
    }
}

