package ss_6.bai_tap.bai_2;

import java.util.Arrays;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D myPoint3D1 = new Point3D();
        System.out.println("myPoint3D1: " + Arrays.toString(myPoint3D1.getXYZ()));
        myPoint3D1.setX(10);
        myPoint3D1.setY(10);
        myPoint3D1.setZ(10);
        System.out.println("myPoint3D1 information: " + myPoint3D1.getX() + ", " + myPoint3D1.getY() + ", " + myPoint3D1.getZ());
        Point3D myPoint3D2 = new Point3D(20, 20, 20);
        myPoint3D2.setXYZ(30,30,30);
        String myMyPoint3D2Information = myPoint3D2.toString();
        System.out.println("myPoint3D2: " + myMyPoint3D2Information);
    }
}
