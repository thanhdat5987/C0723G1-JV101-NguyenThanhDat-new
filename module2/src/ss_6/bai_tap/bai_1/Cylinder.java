package ss_6.bai_tap.bai_1;

public class Cylinder extends Circle {
    private double cylinderHeight;

    public double getCylinderHeight() {
        return cylinderHeight;
    }

    public void setCylinderHeight(double cylinderHeight) {
        this.cylinderHeight = cylinderHeight;
    }

    public double getVolume() {
        return getArea() * getCylinderHeight();
    }

    @Override
    public String toString() {
        return "Cylinder information: radius = " + getRadius() + ", color: " + getColor() + ", height = " + getCylinderHeight() + ", volume = " + getVolume();
    }
}
