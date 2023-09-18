package ss_10.bai_tap.vehicleManagement;

import ss_10.bai_tap.vehicleManagement.model.Car;
import ss_10.bai_tap.vehicleManagement.model.MotoBike;
import ss_10.bai_tap.vehicleManagement.model.Truck;
import ss_10.bai_tap.vehicleManagement.model.Vehicle;
import ss_10.bai_tap.vehicleManagement.view.VehicleManagementView;

public class MainApp {
    Car car = new Car("001", "Yamaha",2000,
            "Dat",4,"sedan");

    Truck truck = new Truck("001", "Yamaha",2015,
            "Toai","5 Ton");

    MotoBike motorcycle = new MotoBike("001", "Yamaha",2020,
            "Quyen", "125CC");

    public static void main(String[] args) {
        VehicleManagementView vehicleView = new VehicleManagementView();
        vehicleView.displayMenu();

    }
    }

