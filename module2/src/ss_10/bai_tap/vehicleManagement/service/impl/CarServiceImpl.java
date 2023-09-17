package ss_10.bai_tap.vehicleManagement.service.impl;

import ss_10.bai_tap.vehicleManagement.model.Vehicle;
import ss_10.bai_tap.vehicleManagement.repository.IVehicleRepository;
import ss_10.bai_tap.vehicleManagement.repository.impl.CarRepositoryImpl;
import ss_10.bai_tap.vehicleManagement.service.IVehicleService;

import java.util.ArrayList;

public class CarServiceImpl implements IVehicleService {
    private IVehicleRepository carRepository = new CarRepositoryImpl();

    @Override
    public void createVehicle(Vehicle vehicle) {
        carRepository.createVehicle(vehicle);
    }

    @Override
    public ArrayList<Object> getVehicle() {
        return carRepository.getVehicle();
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
