package ss_6.bai_tap.bai_1;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder myCylinder = new Cylinder();
        myCylinder.setRadius(10);
        myCylinder.setColor("red");
        myCylinder.setCylinderHeight(10);
        String myCylinderInformation = myCylinder.toString();
        System.out.println(myCylinderInformation);
    }
}
