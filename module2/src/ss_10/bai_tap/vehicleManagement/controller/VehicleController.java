package ss_10.bai_tap.vehicleManagement.controller;

import ss_10.bai_tap.vehicleManagement.model.Vehicle;
import ss_10.bai_tap.vehicleManagement.service.IVehicleService;
import ss_10.bai_tap.vehicleManagement.service.impl.CarServiceImpl;

import java.util.ArrayList;

public class VehicleController {
    private final IVehicleService carService = new CarServiceImpl();

    public void creatCar(Vehicle car) {
        carService.createVehicle(car);
    }

    public ArrayList<Object> getVehicle() {
        return carService.getVehicle();
    }
}
