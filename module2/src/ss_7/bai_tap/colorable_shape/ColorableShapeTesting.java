package ss_7.bai_tap.colorable_shape;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ColorableShapeTesting {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(5);
        shapes[2] = new Rectangle(3, 5);
        shapes[3] = new Square(7);
        System.out.println("Shapes 's area are: ");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof Square) {
                Colorable colorable = (Square) shape;
                colorable.howToColor();
            }
        }
    }
}
