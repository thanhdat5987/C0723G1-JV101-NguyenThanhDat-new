package com.example.car.model;

public class Car {
    private int carId;
    private String name;
    private int carTypeId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Car(int carId, String name, int carTypeId) {
        this.carId = carId;
        this.name = name;
        this.carTypeId = carTypeId;
    }
}
