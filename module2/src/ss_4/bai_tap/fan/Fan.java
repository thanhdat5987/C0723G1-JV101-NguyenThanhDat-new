package ss_4.bai_tap.fan;

public class Fan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        String statusFan1 = fan1.toString();
        System.out.println("Fan 1 information: " + statusFan1);
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        String statusFan2 = fan2.toString();
        System.out.println("Fan 2 information: " + statusFan2);
    }

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

