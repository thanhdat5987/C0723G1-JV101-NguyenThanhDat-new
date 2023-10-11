package de_mo.thuc_hanh_mvc1.controller;

import de_mo.thuc_hanh_mvc1.model.Car;
import de_mo.thuc_hanh_mvc1.service.ICarService;
import de_mo.thuc_hanh_mvc1.service.impl.CarServiceImpl;

import java.util.List;

public class CarController {
    private final ICarService carService = new CarServiceImpl();
    public void addCar(Car car) {
        carService.addCar(car);
    }


    public List<Car> getListCar() {
        return carService.getListCar();
    }


    public Car getCar(int index) {
        return null;
    }


    public void deleteCar(int index) {
carService.deleteCar(index);
    }
}
