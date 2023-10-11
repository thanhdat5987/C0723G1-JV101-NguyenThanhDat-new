package case_study.furama.view;

import case_study.furama.controller.FacilityController;
import case_study.furama.model.Facility;
import case_study.furama.model.House;
import case_study.furama.model.Room;
import case_study.furama.model.Villa;
import case_study.furama.util.Validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityManagementView {
    private static Scanner scanner = new Scanner(System.in);
    private static final FacilityController facilityController = new FacilityController();

    public static void displayFacilityManagementMenu() {

        int facilityManagementChoice = 0;
        while (facilityManagementChoice != 5) {
            try {
                System.out.println("===Facility Management Menu===");
                System.out.println("1.Display list facilities");
                System.out.println("2.Add new facility");
                System.out.println("3.Display list facilities maintenance");
                System.out.println("4.Delete facility");
                System.out.println("5.Return main Menu");
                System.out.println("Please enter your choose");
                facilityManagementChoice = Integer.parseInt(scanner.nextLine());
                switch (facilityManagementChoice) {
                    case 1:
                        displayListFacilities();
                        break;
                    case 2:
                        displayMenuAddNewFacility();
                        break;
                    case 3:
                        displayListFacilitiesMaintenance();
                        break;
                    case 4:
                        deleteFacility();
                        break;
                    case 5:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Please enter your choice again!");
            }
        }
    }

    public static void displayListFacilities() {
        LinkedHashMap<Facility, Integer> facilityList = facilityController.displayFacility();
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            System.out.println(entry.getKey() + ", using time: " + entry.getValue());
        }
    }

    public static void displayMenuAddNewFacility() {
        int facilityChoice = 0;
        while (facilityChoice != 4) {
            try {
                System.out.println("Please choose:");
                System.out.println("1.Add New Villa");
                System.out.println("2.Add New House");
                System.out.println("3.Add New Room");
                System.out.println("4.Back to menu");
                facilityChoice = Integer.parseInt(scanner.nextLine());
                switch (facilityChoice) {
                    case 1:
                        addNewVilla();
                        break;
                    case 2:
                        addNewHouse();
                        break;
                    case 3:
                        addNewRoom();
                        break;
                    case 4:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "please enter again.");
            }
        }
    }

    public static void addNewVilla() {
        Villa newVilla = new Villa();
        String villaServiceId = enterNewVillaServiceId();
        newVilla.setServiceId(villaServiceId);
        String villaServiceName = Validation.enterServiceName();
        newVilla.setServiceName(villaServiceName);
        float villaUsableArea = Validation.enterUsableArea();
        newVilla.setUsableArea(villaUsableArea);
        int rentalCost = Validation.enterRentalCost();
        newVilla.setRentalCost(rentalCost);
        int villaCapacity = Validation.enterCapacity();
        newVilla.setCapacity(villaCapacity);
        String rentalType = Validation.enterRentalType();
        newVilla.setRentalType(rentalType);
        String roomStandards = Validation.enterRoomStandard();
        newVilla.setRoomStandards(roomStandards);
        float swimmingPoolArea = Validation.enterSwimmingPoolArea();
        newVilla.setPoolArea(swimmingPoolArea);
        int numberOfFloor = Validation.enterNumberOfFloor();
        newVilla.setNumberOfFloor(numberOfFloor);
        facilityController.add(newVilla);
    }

    public static void addNewHouse() {
        House newHouse = new House();
        String houseServiceId = enterNewHouseServiceId();
        newHouse.setServiceId(houseServiceId);
        String houseServiceName = Validation.enterServiceName();
        newHouse.setServiceName(houseServiceName);
        float houseUsableArea = Validation.enterUsableArea();
        newHouse.setUsableArea(houseUsableArea);
        int rentalCost = Validation.enterRentalCost();
        newHouse.setRentalCost(rentalCost);
        int houseCapacity = Validation.enterCapacity();
        newHouse.setCapacity(houseCapacity);
        String rentalType = Validation.enterRentalType();
        newHouse.setRentalType(rentalType);
        String roomStandards = Validation.enterRoomStandard();
        newHouse.setRoomStandards(roomStandards);
        int numberOfFloor = Validation.enterNumberOfFloor();
        newHouse.setNumberOfFloor(numberOfFloor);
        facilityController.add(newHouse);
    }

    public static void addNewRoom() {
        Room newRoom = new Room();
        String roomServiceId = enterNewRoomServiceId();
        newRoom.setServiceId(roomServiceId);
        String houseServiceName = Validation.enterServiceName();
        newRoom.setServiceName(houseServiceName);
        float houseUsableArea = Validation.enterUsableArea();
        newRoom.setUsableArea(houseUsableArea);
        int rentalCost = Validation.enterRentalCost();
        newRoom.setRentalCost(rentalCost);
        int houseCapacity = Validation.enterCapacity();
        newRoom.setCapacity(houseCapacity);
        String rentalType = Validation.enterRentalType();
        newRoom.setRentalType(rentalType);
        String freeService = enterFreeService();
        newRoom.setFreeService(freeService);
        facilityController.add(newRoom);
    }


    public static void displayListFacilitiesMaintenance() {
        LinkedHashMap<Facility, Integer> facilityList = facilityController.displayFacility();
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + ", using time: " + entry.getValue());
            }
        }
    }

    public static void deleteFacility() {
        String deletingFacilityId = checkServiceId();
        final String confirm;
        System.out.println("Are you sure? Enter Y to confirm");
        confirm =scanner.nextLine();
        if(confirm.equals("Y")){
            getKeyById(deletingFacilityId);
            facilityController.deleteFacility(findingFacility);
            System.out.println("Delete successfully");
        }
    }

    private static Facility findingFacility;

    public static void getKeyById(String facilityServiceId) {
        LinkedHashMap<Facility, Integer> facilityList = facilityController.displayFacility();
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getKey().getServiceId().equals(facilityServiceId)) {
                findingFacility = entry.getKey();
            }
        }
    }

    public static Boolean checkFacilityServiceId(String newVillaServiceId) {
        LinkedHashMap<Facility, Integer> facilityList = facilityController.displayFacility();
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getKey().getServiceId().equals(newVillaServiceId)) {
                return true;
            }
        }
        return false;
    }

    public static String enterNewVillaServiceId() {
        do {
            String newVillaServiceId;
            newVillaServiceId = Validation.enterVillaServiceId();
            if (!checkFacilityServiceId(newVillaServiceId)) {
                return newVillaServiceId;
            } else {
                System.out.println("VillaService Id has been exist, please enter again");
            }
        } while (true);
    }

    public static String enterNewHouseServiceId() {
        do {
            String newHouseServiceId;
            newHouseServiceId = Validation.enterHouseServiceId();
            if (!checkFacilityServiceId(newHouseServiceId)) {
                return newHouseServiceId;
            } else {
                System.out.println("HouseService Id has been exist, please enter again");
            }
        } while (true);
    }
    public static String enterNewRoomServiceId() {
        do {
            String newRoomServiceId;
            newRoomServiceId = Validation.enterRoomServiceId();
            if (!checkFacilityServiceId(newRoomServiceId)) {
                return newRoomServiceId;
            } else {
                System.out.println("Room Service Id has been exist, please enter again");
            }
        } while (true);
    }
    public static String enterFreeService(){
        String freeService;
        System.out.println("Enter Free service of room: ");
        freeService = scanner.nextLine();
        return freeService;
    }

    public static String checkServiceId() {
        do {
            String serviceId;
            System.out.println("Enter service Id");
            serviceId =scanner.nextLine();
            if (checkFacilityServiceId(serviceId)) {
                return serviceId;
            } else {
                System.out.println("Service Id has not been exist, please enter again");
            }
        } while (true);
    }
}
