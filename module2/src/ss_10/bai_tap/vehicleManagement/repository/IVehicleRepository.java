package ss_10.bai_tap.vehicleManagement.repository;

import ss_10.bai_tap.vehicleManagement.model.Vehicle;

import java.util.ArrayList;

public interface IVehicleRepository<E> {
    void createVehicle(E vehicle);
    ArrayList<E> getVehicleDetail();

    public void deleteVehicle(int index);
    public E getVehicle(int index);
}
