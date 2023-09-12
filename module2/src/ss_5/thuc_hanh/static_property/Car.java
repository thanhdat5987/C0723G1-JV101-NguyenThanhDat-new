package ss_5.thuc_hanh.static_property;

public class Car {
    private final String name;
    private final String engine;
    public static int numberOfCar;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCar++;
    }


}
