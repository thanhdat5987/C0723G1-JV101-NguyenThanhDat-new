package com.example.car.service;

import com.example.car.model.Car;
import com.example.car.model.CarDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICarService {
    List<CarDTO> selectAllCar() throws SQLException;
    public void addCar(Car car) throws SQLException;
    boolean deleteCar(int id) throws SQLException;
}
