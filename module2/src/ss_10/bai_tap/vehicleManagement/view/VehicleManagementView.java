package ss_10.bai_tap.vehicleManagement.view;


import ss_10.bai_tap.vehicleManagement.controller.VehicleController;

import java.util.ArrayList;

public class VehicleManagementView  {

   private final VehicleController vehicleController = new VehicleController();
   ArrayList<Object> cars = vehicleController.getVehicle();
   
}
