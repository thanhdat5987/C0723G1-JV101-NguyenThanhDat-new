package de_mo.thuc_hanh_mvc1.view;

import de_mo.thuc_hanh_mvc1.controller.CarController;
import de_mo.thuc_hanh_mvc1.model.Car;
import de_mo.thuc_hanh_mvc1.util.Validation;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CarManagementView {
    private static final CarController carController = new CarController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        int choice = 0;
        while (choice != 5) {
            try {
                System.out.println("Menu");
                System.out.println("1.Add car");
                System.out.println("2.Show cars list");
                System.out.println("3.Edit car");
                System.out.println("4.Delete car");
                System.out.println("6.Sort car");
                System.out.println("5.Exit");
                System.out.println("Please enter your choice");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addCar();
                        break;
                    case 2:
                        showCarsList();
                        break;
                    case 3:
                        editCar();
                        break;
                    case 4:
                        deleteCar();
                        break;
                    case 6:
                        sortCars();
                        break;
                    case 5:
                        System.exit(5);

                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ", please enter your choice again");
            }
        }
    }

    public static void addCar() {
        String newId;
        do {
            newId = enterCarId();
            if (checkIndexById(newId) == -1) {
                break;
            } else {
                System.out.println("Id has been exits please enter again");
            }
        } while (true);
        System.out.println("Enter car name");
        String carName = scanner.nextLine();
        int carPrice = enterCarPrice();
        Car newCar = new Car(newId, carName, carPrice);
        carController.addCar(newCar);
    }

    public static void showCarsList() {
        List<Car> listCars = carController.getListCar();
        for (Car car : listCars) {
            System.out.println(car);
        }
    }

    public static void sortCars() {
        List<Car> listCars = carController.getListCar();
        Car temp;
        for (int i = 0; i < listCars.size() - 1; i++) {
            for (int j = i + 1; j < listCars.size(); j++) {
                if (Integer.parseInt(listCars.get(i).getCarId().substring(2, 6)) > Integer.parseInt(listCars.get(j).getCarId().substring(2, 6))) {
                    temp = listCars.get(j);
                    listCars.set(j, listCars.get(i));
                    listCars.set(i, temp);
                }
            }
        }
        for (Car car : listCars) {
            System.out.println(car);
        }
    }

    public static void editCar() {

    }

    public static void deleteCar() {
        String deletingId = enterCarId();
        if (checkIndexById(deletingId) != -1) {
            carController.deleteCar(checkIndexById(deletingId));
            System.out.println("Delete successfully");
        } else {
            System.out.println("Can't find id");
        }
    }

    public static String enterCarId() {
        String carId;
        do {
            System.out.println("Enter car Id following format C-xxxx (x is number from 0-9):");
            carId = scanner.nextLine();
            if (Validation.validateCarId(carId)) {
                return carId;
            } else {
                System.out.println("please following format C-xxxx (x is number from 0-9)");
            }
        } while (true);
    }

    public static int enterCarPrice() {
        int carPrice;
        do {
            try {
                System.out.println("Enter car price");
                carPrice = Integer.parseInt(scanner.nextLine());
                return carPrice;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " please enter again");
            }
        } while (true);
    }

    public static int checkIndexById(String id) {
        int index = -1;
        List<Car> listCars = carController.getListCar();
        for (int i = 0; i < listCars.size(); i++) {
            if (listCars.get(i).getCarId().equals(id)) {
                index = i;
            }
        }
        return index;
    }
}
