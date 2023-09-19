package ss_10.bai_tap.vehicleManagement.model;

public class Car extends Vehicle {
    private int numberOfSeat;
    private String carType;

    public Car(int numberOfSeat, String carType) {
        this.numberOfSeat = numberOfSeat;
        this.carType = carType;
    }

    public Car(String licensePlate, String manufacturer, int yearOfManufacture, String ownerName, int numberOfSeat, String carType) {
        super(licensePlate, manufacturer, yearOfManufacture, ownerName);
        this.numberOfSeat = numberOfSeat;
        this.carType = carType;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeat=" + numberOfSeat +
                ", carType='" + carType + '\'' +
                "} " + super.toString();
    }
}
