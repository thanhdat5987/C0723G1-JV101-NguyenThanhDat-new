package ss_10.bai_tap.vehicleManagement.view;


import ss_10.bai_tap.vehicleManagement.controller.VehicleController;
import ss_10.bai_tap.vehicleManagement.model.Car;
import ss_10.bai_tap.vehicleManagement.model.MotoBike;
import ss_10.bai_tap.vehicleManagement.model.Truck;
import ss_10.bai_tap.vehicleManagement.model.Vehicle;

import java.util.Scanner;

public class VehicleManagementView {

    private static Scanner scanner = new Scanner(System.in);
    private final VehicleController<Car> carController = new VehicleController<>();
    private final VehicleController<MotoBike> motoBikeController = new VehicleController<>();
    private final VehicleController<Truck> truckController = new VehicleController<>();
    private String licensePlate;

    private String manufacturer;

    private int yearOfManufacture;

    private String ownerName;
    private int carLicensePlateIndex = -1;
    private int truckLicensePlateIndex = -1;
    private int motoBikeLicensePlateIndex = -1;


    public void displayMenu() {
        System.out.println("Please choose function:");
        System.out.println("1. Add a new vehicle");
        System.out.println("2. Display list of vehicles");
        System.out.println("3. Delete a vehicle");
        System.out.println("4. Search a vehicle by licensePlate");
        System.out.println("5. Exit");

        int choose = Integer.parseInt(scanner.nextLine());

        switch (choose) {
            case 1:
                addVehicle();
                displayMenu();
                break;
            case 2:
                displayVehicle();
                displayMenu();
                break;
            case 3:
                deleteVehicle();
                displayMenu();
                break;
            case 4:
                searchVehicle();
                displayMenu();
                break;
            case 5:
                System.exit(5);
        }

    }

    // Creat
    private void addVehicle() {
        System.out.println("Please choose type of vehicle you want to add:");
        System.out.println("1. Add Car");
        System.out.println("2. Add Truck");
        System.out.println("3. Add Motorcycle");

        int choose = Integer.parseInt(scanner.nextLine());

        switch (choose) {
            case 1:
                addCar();
                break;
            case 2:
                addTruck();
                break;
            case 3:
                addMotorCycle();
                break;
        }
    }

    private void addVehicleInformation() {
        System.out.println("Add license plate:");
        licensePlate = scanner.nextLine();
        System.out.println("Add manufacturer:");
        manufacturer = scanner.nextLine();
        System.out.println("Add year:");
        yearOfManufacture = Integer.parseInt(scanner.nextLine());
        System.out.println("Add owner:");
        ownerName = scanner.nextLine();
    }


    private void addCar() {
        addVehicleInformation();
        System.out.println("Add number of seat:");
        int numberOfSeat = Integer.parseInt(scanner.nextLine());
        System.out.println("Add car type:");
        String carType = scanner.nextLine();
        Car car = new Car(licensePlate, manufacturer, yearOfManufacture, ownerName, numberOfSeat, carType);
        carController.createVehicle(car);
    }

    private void addTruck() {
        addVehicleInformation();
        System.out.println("Add load ability:");
        String truckWeight = scanner.nextLine();
        Truck truck = new Truck(licensePlate, manufacturer, yearOfManufacture, ownerName, truckWeight);
        truckController.createVehicle(truck);
    }

    private void addMotorCycle() {
        addVehicleInformation();
        System.out.println("Add power:");
        String engineCapacity = scanner.nextLine();
        MotoBike motoBike = new MotoBike(licensePlate, manufacturer, yearOfManufacture, ownerName, engineCapacity);
        motoBikeController.createVehicle(motoBike);
    }

    //Display
    private void displayCars() {
        for (Car car : carController.getVehicleDetail()) {
            System.out.println(car);
        }
    }

    private void displayTrucks() {
        for (Truck truck : truckController.getVehicleDetail()) {
            System.out.println(truck);
        }
    }

    private void displayMotorCycles() {
        for (MotoBike motorcycle : motoBikeController.getVehicleDetail()) {
            System.out.println(motorcycle);
        }
    }

    private void displayVehicle() {
        System.out.println("Please choose the vehicle you want to show:");
        System.out.println("1. Show Car list");
        System.out.println("2. Show Truck list");
        System.out.println("3. Show Motorcycle list");
        int choose = Integer.parseInt(scanner.nextLine());

        switch (choose) {
            case 1:
                displayCars();
                break;
            case 2:
                displayTrucks();
                break;
            case 3:
                displayMotorCycles();
                break;
        }
    }

    // Find index following license Plate:
    private void findLicensePlateIndex(String licensePlate) {
        for (int i = 0; i < carController.getVehicleDetail().size(); i++) {
            if (carController.getVehicleDetail().get(i).getLicensePlate().equals(licensePlate)) {
                carLicensePlateIndex = i;
                break;
            }
        }
        for (int i = 0; i < truckController.getVehicleDetail().size(); i++) {
            if (truckController.getVehicleDetail().get(i).getLicensePlate().equals(licensePlate)) {
                truckLicensePlateIndex = i;
                break;
            }
        }
        for (int i = 0; i < motoBikeController.getVehicleDetail().size(); i++) {
            if (motoBikeController.getVehicleDetail().get(i).getLicensePlate().equals(licensePlate)) {
                motoBikeLicensePlateIndex = i;
                break;
            }
        }
    }

    //delete Vehicle
    private void deleteVehicle() {
        System.out.println("Please enter the licensePlate of vehicle that you want to delete ");
        String deletingLicensePlate = scanner.nextLine();
        findLicensePlateIndex(deletingLicensePlate);
        if ((carLicensePlateIndex + truckLicensePlateIndex + motoBikeLicensePlateIndex) != -3) {
            System.out.println("Do you want to delete the vehicle with License Plate is " + deletingLicensePlate);
            System.out.println("If Yes, please enter 1. If No, please enter 2");
            int deleteOption = Integer.parseInt(scanner.nextLine());
            switch (deleteOption) {
                case 1:
                    if (carLicensePlateIndex != -1) {
                        deleteCar(carLicensePlateIndex);
                    } else if (truckLicensePlateIndex != -1) {
                        deleteTruck(truckLicensePlateIndex);
                    } else if (motoBikeLicensePlateIndex != -1) {
                        deleteMotoBike(carLicensePlateIndex);
                    }
                    System.out.println("Delete successfully!");
                    break;
                case 2:
                    displayMenu();
                    break;
            }
        } else {
            System.out.println("Can't find the License Plate");
        }
    }

    private void deleteCar(int carLicensePlateIndex) {
        carController.deleteVehicle(carLicensePlateIndex);
    }

    private void deleteTruck(int truckLicensePlateIndex) {
        truckController.deleteVehicle(truckLicensePlateIndex);
    }

    private void deleteMotoBike(int motoBikeLicensePlateIndex) {
        motoBikeController.deleteVehicle(motoBikeLicensePlateIndex);
    }

    // Search Vehicle
    private void searchVehicle() {
        System.out.println("Please enter the licensePlate of vehicle that you want to find ");
        String findingLicensePlate = scanner.nextLine();
        findLicensePlateIndex(findingLicensePlate);
        if (carLicensePlateIndex != -1) {
            System.out.println("Car: " + carController.getVehicle(carLicensePlateIndex));
        } else if (truckLicensePlateIndex != -1) {
            System.out.println("Truck: " + truckController.getVehicle(truckLicensePlateIndex));
        } else if (motoBikeLicensePlateIndex != -1) {
            System.out.println("Motobike: " + motoBikeController.getVehicle(motoBikeLicensePlateIndex));
        } else {
            System.out.println("Can't find the Licence Plate");
        }
    }

}
