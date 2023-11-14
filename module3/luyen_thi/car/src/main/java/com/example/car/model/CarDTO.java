package com.example.car.model;

public class CarDTO {
    private int id;
    private String name;
    private String carType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public CarDTO(String name, String carType) {
        this.name = name;
        this.carType = carType;
    }

    public CarDTO(int id, String name, String carType) {
        this.id = id;
        this.name = name;
        this.carType = carType;
    }
}
