package ss_4.bai_tap.fan;

public class Main {
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
}
