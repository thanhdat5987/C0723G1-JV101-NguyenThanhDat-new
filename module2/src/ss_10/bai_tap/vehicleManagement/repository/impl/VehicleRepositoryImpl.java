package ss_10.bai_tap.vehicleManagement.repository.impl;

import ss_10.bai_tap.vehicleManagement.model.Vehicle;
import ss_10.bai_tap.vehicleManagement.repository.IVehicleRepository;

import java.util.ArrayList;

public class VehicleRepositoryImpl<E> implements IVehicleRepository<E> {
private final ArrayList<E> vehicles= new ArrayList<>();
    @Override
    public void createVehicle(E vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public ArrayList<E> getVehicleDetail() {
        return vehicles;
    }

    @Override
    public void deleteVehicle(String licensePlate) {

    }

    @Override
    public void getVehicle(String licensePlate) {
//return vehicles.get();
    }
}
