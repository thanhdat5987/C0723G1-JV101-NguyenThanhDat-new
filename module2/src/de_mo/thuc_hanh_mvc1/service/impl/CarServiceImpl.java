package de_mo.thuc_hanh_mvc1.service.impl;

import de_mo.thuc_hanh_mvc1.model.Car;
import de_mo.thuc_hanh_mvc1.repository.ICarRepository;
import de_mo.thuc_hanh_mvc1.repository.impl.CarRepositoryImpl;
import de_mo.thuc_hanh_mvc1.service.ICarService;

import java.util.List;

public class CarServiceImpl implements ICarService {
    private final ICarRepository carRepository = new CarRepositoryImpl();

    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public List<Car> getListCar() {
        return carRepository.getListCar();
    }

    @Override
    public Car getCar(int index) {
        return null;
    }

    @Override
    public void deleteCar(int index) {
carRepository.deleteCar(index);
    }

    @Override
    public void editCar(int index, Car car) {

    }
}
