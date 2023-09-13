package ss_7.bai_tap.resizeable_shape;

public class ResizeableShapeTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 5);
        shapes[2] = new Square(4);
        System.out.println("The area before resize: ");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
        double percent = 100 * Math.random();
        System.out.println("Resize rate = " + percent+" %");
        System.out.println("The area after resize: ");
        for (Shape shape : shapes) {
            shape.resize(percent);
            System.out.println(shape.getArea());
        }
    }
}
