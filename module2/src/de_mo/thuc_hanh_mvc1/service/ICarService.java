package de_mo.thuc_hanh_mvc1.service;

import de_mo.thuc_hanh_mvc1.model.Car;

import java.util.List;

public interface ICarService {
    void addCar(Car car);
    List<Car> getListCar();
    Car getCar(int index);
    void deleteCar(int index);
    void editCar(int index, Car car);
}
