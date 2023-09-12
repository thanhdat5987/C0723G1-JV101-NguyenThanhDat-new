package ss_6.bai_tap.bai_1;

public class CircleTest {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        myCircle.setRadius(5);
        myCircle.setColor("blue");
        String myCircleInformation = myCircle.toString();
        System.out.println(myCircleInformation);
    }
}
