package ss_10.bai_tap.vehicleManagement.controller;

import ss_10.bai_tap.vehicleManagement.service.IVehicleService;
import ss_10.bai_tap.vehicleManagement.service.impl.VehicleServiceImpl;

import java.util.ArrayList;

public class VehicleController<E> {
    private final IVehicleService<E> vehicleService = new VehicleServiceImpl<>();

    public void createVehicle(E vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    public ArrayList<E> getVehicleDetail() {
        return vehicleService.getVehicleDetail();
    }

    public void deleteVehicle(String licensePlate) {
        vehicleService.deleteVehicle(licensePlate);
    }


    public void getVehicle(String licensePlate) {
        vehicleService.getVehicle(licensePlate);
    }
}
