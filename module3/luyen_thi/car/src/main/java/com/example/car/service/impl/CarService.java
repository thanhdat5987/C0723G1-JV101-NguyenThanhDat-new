package com.example.car.service.impl;

import com.example.car.model.Car;
import com.example.car.model.CarDTO;
import com.example.car.repository.ICarRepository;
import com.example.car.repository.impl.CarRepository;
import com.example.car.service.ICarService;

import java.sql.SQLException;
import java.util.List;

public class CarService implements ICarService {
    private ICarRepository carRepository = new CarRepository();

    @Override
    public List<CarDTO> selectAllCar() throws SQLException {
        return carRepository.selectAllCar();
    }

    @Override
    public void addCar(Car car) throws SQLException {
        carRepository.addCar(car);
    }

    @Override
    public boolean deleteCar(int id) throws SQLException {
        return carRepository.deleteCar(id);
    }
}
