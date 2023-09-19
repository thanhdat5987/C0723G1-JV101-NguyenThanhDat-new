package ss_10.bai_tap.vehicleManagement;

import ss_10.bai_tap.vehicleManagement.model.Car;
import ss_10.bai_tap.vehicleManagement.model.MotoBike;
import ss_10.bai_tap.vehicleManagement.model.Truck;
import ss_10.bai_tap.vehicleManagement.model.Vehicle;
import ss_10.bai_tap.vehicleManagement.view.VehicleManagementView;

public class MainApp {

    public static void main(String[] args) {
        VehicleManagementView vehicleView = new VehicleManagementView();
        vehicleView.displayMenu();
    }
}

