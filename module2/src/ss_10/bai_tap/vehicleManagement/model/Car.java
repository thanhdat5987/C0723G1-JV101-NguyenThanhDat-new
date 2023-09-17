package ss_10.bai_tap.vehicleManagement.model;

public class Car extends Vehicle {
    private int numberOfSeat;
    private java.lang.String carType;

    public Car(int numberOfSeat, java.lang.String carType) {
        this.numberOfSeat = numberOfSeat;
        this.carType = carType;
    }

    public Car(java.lang.String licensePlate, String manufacturer, int yearOfManufacture, java.lang.String ownerName, int numberOfSeat, java.lang.String carType) {
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

    public java.lang.String getCarType() {
        return carType;
    }

    public void setCarType(java.lang.String carType) {
        this.carType = carType;
    }

    @Override
    public java.lang.String toString() {
        return "Car{" +
                "numberOfSeat=" + numberOfSeat +
                ", carType='" + carType + '\'' +
                "} " + super.toString();
    }
}
