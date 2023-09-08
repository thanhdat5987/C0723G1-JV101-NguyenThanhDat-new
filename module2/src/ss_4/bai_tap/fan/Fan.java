package ss_4.bai_tap.fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed;
    private double radius;
    private String color;
    private boolean on;


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOn(boolean status) {
        this.on = status;
    }

    public boolean getOn() {
        return on;
    }

    public String toString() {
        if (getOn()) {
            return getSpeed() + ", " + getColor() + ", " + getRadius() + ", Fan is on";
        } else {
            return getColor() + ", " + getRadius() + ", Fan is off";
        }
    }

    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }

}

