package ss_5.bai_tap.access_modifier_01;

public class TestCircle {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5);
        myCircle.getRadius();
        myCircle.getArea();
//        Private method getRadius1 and Private method getArea1 could not use outside the class:
//        Circle myCircle1 = new Circle(10);
//        myCircle1.getRadius1();
//        myCircle1.getArea1();
    }
}
