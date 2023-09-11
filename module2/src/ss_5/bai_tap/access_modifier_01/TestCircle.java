package ss_5.bai_tap.access_modifier_01;

public class TestCircle {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5);
        System.out.println("Radius of Circle is " + myCircle.getRadius() + ". The Area of Circle is: " + myCircle.getArea() + ". Color is: " + myCircle.getColor());
        // method private getRadius1 and private getArea1 could not use outside the class:
        //  Circle myCircle1 = new Circle(10);
        //  System.out.println("Radius of Circle is " + myCircle1.getRadius1() + ". The Area of Circle is: " + myCircle1.getArea1() + ". Color is: " + myCircle1.getColor());
    }
}
