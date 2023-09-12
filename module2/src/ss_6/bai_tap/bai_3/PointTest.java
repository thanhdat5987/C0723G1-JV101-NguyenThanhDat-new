package ss_6.bai_tap.bai_3;

import ss_6.bai_tap.bai_2.Point2D;

import java.util.Arrays;

public class PointTest {
    public static void main(String[] args) {
        Point myPoint1 = new Point();
        System.out.println("myPoint1 " + Arrays.toString(myPoint1.getXY()));
        myPoint1.setX(1);
        myPoint1.setY(1);
        System.out.println("My Point1 information: " + myPoint1.getX() + ", " + myPoint1.getY());
        Point myPoint2 = new Point(2, 2);
        myPoint2.setXY(2,2);
        String myPoint2Information = myPoint2.toString();
        System.out.println("myPoint2: " + myPoint2Information);
    }
}
