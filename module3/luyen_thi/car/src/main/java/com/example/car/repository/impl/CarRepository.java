package com.example.car.repository.impl;

import com.example.car.model.Car;
import com.example.car.model.CarDTO;
import com.example.car.repository.BaseRepository;
import com.example.car.repository.ICarRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {
    private final String SELECT_ALL_CAR ="";
    @Override
    public List<CarDTO> selectAllCar() throws SQLException {
        List<CarDTO> listCar = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        return null;
    }

    @Override
    public void addCar(Car car) throws SQLException {

    }

    @Override
    public boolean deleteCar(int id) throws SQLException {
        return false;
    }
}
