package ss_6.thuc_hanh.shape;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Shape shape1 = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
    }
}
