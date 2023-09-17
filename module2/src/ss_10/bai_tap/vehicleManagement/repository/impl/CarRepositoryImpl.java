package ss_10.bai_tap.vehicleManagement.repository.impl;

import ss_10.bai_tap.vehicleManagement.model.Car;
import ss_10.bai_tap.vehicleManagement.model.Vehicle;
import ss_10.bai_tap.vehicleManagement.repository.IVehicleRepository;

import java.util.ArrayList;

public class CarRepositoryImpl implements IVehicleRepository {
    Car car1 = new Car("", "", 1999, "Nguyen Thanh Dat", 4, "travel");
    ArrayList<Object> cars = new ArrayList<>();
    @Override
    public void createVehicle(Vehicle vehicle) {
        cars.add(car1);
        cars.add(vehicle);
    }

    @Override
    public ArrayList<Object> getVehicle() {
        return cars;
    }


    @Override
    public void updateVehicle(Vehicle newVehicle) {

    }

    @Override
    public void deleteVehicle(String licensePlate) {

    }

    @Override
    public Vehicle findVehicle(String licensePlate) {
        return null;
    }
}
