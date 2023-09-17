package ss_10.bai_tap.vehicleManagement.repository;

import ss_10.bai_tap.vehicleManagement.model.Vehicle;

import java.util.ArrayList;

public interface IVehicleRepository {
    void createVehicle(Vehicle vehicle);
    ArrayList<Object> getVehicle();

    void updateVehicle(Vehicle newVehicle);

    void deleteVehicle(String licensePlate);
    Vehicle findVehicle(String licensePlate);
}
