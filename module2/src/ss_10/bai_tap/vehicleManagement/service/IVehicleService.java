package ss_10.bai_tap.vehicleManagement.service;

import ss_10.bai_tap.vehicleManagement.model.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

public interface IVehicleService {
    void createVehicle(Vehicle vehicle);
    ArrayList<Object> getVehicle();

    void updateVehicle(Vehicle newVehicle);

    void deleteVehicle(String licensePlate);
    Vehicle findVehicle(String licensePlate);
}
