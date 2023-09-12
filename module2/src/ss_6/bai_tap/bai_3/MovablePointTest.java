package ss_6.bai_tap.bai_3;

import java.util.Arrays;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint myMovablePoint = new MovablePoint(1, 1, 5, 3);
        System.out.println("My point: ");
        System.out.println(Arrays.toString(myMovablePoint.getXY()));
        System.out.println(Arrays.toString(myMovablePoint.getSpeed()));
        myMovablePoint.move();
        System.out.println("After run 1st time: " + Arrays.toString(myMovablePoint.getXY()));
        myMovablePoint.setXSpeed(1);
        myMovablePoint.setYSpeed(2);
        myMovablePoint.move();
        System.out.println("After run 2nd time: " + Arrays.toString(myMovablePoint.getXY()));
        String myMovablePointInformation = myMovablePoint.toString();
        System.out.println("My point information: " + myMovablePointInformation);
    }
}
