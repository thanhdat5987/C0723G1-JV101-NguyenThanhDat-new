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

    private double getRadius1() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return getRadius() * getRadius() * Math.PI;
    }

    private double getArea1() {
        return getRadius() * getRadius() * Math.PI;
    }

    public static void main(String[] args) {
        Circle myCircle = new Circle(5);
        System.out.println("Radius of Circle is "+ myCircle.getRadius()+". The Area of Circle is: "+ myCircle.getArea()+". Color is: "+myCircle.getColor());
        // method private getRadius1 and private getArea1 can use inside the class:
        Circle myCircle1 = new Circle(10);
        System.out.println("Radius of Circle is "+ myCircle1.getRadius1()+". The Area of Circle is: "+ myCircle1.getArea1()+". Color is: "+myCircle1.getColor());
    }
}

