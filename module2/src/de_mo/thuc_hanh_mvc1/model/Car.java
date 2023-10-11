package de_mo.thuc_hanh_mvc1.model;

public class Car implements Comparable{
    private String carId;
    private String carName;
    private int price;

    public Car() {
    }

    public Car(String carId, String carName, int price) {
        this.carId = carId;
        this.carName = carName;
        this.price = price;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
