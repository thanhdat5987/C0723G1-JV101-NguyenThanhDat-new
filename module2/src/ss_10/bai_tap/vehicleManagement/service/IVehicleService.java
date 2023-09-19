package ss_10.bai_tap.vehicleManagement.service;

import ss_10.bai_tap.vehicleManagement.model.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

public interface IVehicleService<E> {
    void createVehicle(E vehicle);
    ArrayList<E> getVehicleDetail();

    void deleteVehicle(int index);
    E getVehicle(int index);
}
