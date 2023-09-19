package ss_10.bai_tap.vehicleManagement.service.impl;

import ss_10.bai_tap.vehicleManagement.repository.IVehicleRepository;
import ss_10.bai_tap.vehicleManagement.repository.impl.VehicleRepositoryImpl;
import ss_10.bai_tap.vehicleManagement.service.IVehicleService;

import java.util.ArrayList;

public class VehicleServiceImpl<E> implements IVehicleService<E> {
    private final IVehicleRepository<E> vehicleRepository = new VehicleRepositoryImpl<>();

    @Override
    public void createVehicle(E vehicle) {
        vehicleRepository.createVehicle(vehicle);
    }

    @Override
    public ArrayList<E> getVehicleDetail() {
        return vehicleRepository.getVehicleDetail();
    }

    @Override
    public void deleteVehicle(int index) {
        vehicleRepository.deleteVehicle(index);
    }

    @Override
    public E getVehicle(int index) {
        return vehicleRepository.getVehicle(index);
    }
}
