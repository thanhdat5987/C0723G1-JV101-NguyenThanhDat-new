package com.example.car.model;

public class CarType {
    private int carTypeId;
    private String carTypeName;

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public CarType(int carTypeId, String carTypeName) {
        this.carTypeId = carTypeId;
        this.carTypeName = carTypeName;
    }
}
