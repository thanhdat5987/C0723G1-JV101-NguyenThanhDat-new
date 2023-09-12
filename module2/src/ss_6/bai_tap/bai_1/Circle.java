package ss_6.bai_tap.bai_1;

public class Circle {
    private double radius;
    private String color;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return getRadius()*getRadius()*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle information: radius = "+ getRadius()+", color: "+getColor()+", area = "+getArea();
    }
}
