package ss_6.bai_tap.bai_2;

import java.util.Arrays;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D myPoint2D1 = new Point2D();
        System.out.println("myPoint2D1 " + Arrays.toString(myPoint2D1.getXY()));
        myPoint2D1.setX(10);
        myPoint2D1.setY(11);
        System.out.println("My Point2D1 information: " + myPoint2D1.getX() + ", " + myPoint2D1.getY());
        Point2D myPoint2D2 = new Point2D(4, 5);
        myPoint2D2.setXY(9,10);
        String myPoint2D2Information = myPoint2D2.toString();
        System.out.println("myPoint2D2: " + myPoint2D2Information);
    }
}
