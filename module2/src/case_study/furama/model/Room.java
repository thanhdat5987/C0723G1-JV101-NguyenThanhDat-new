package case_study.furama.model;

public class Room extends Facility {
    private String freeService;

    public Room(String serviceId, String serviceName, float usableArea, int rentalCost, int capacity, String rentalType, String freeService) {
        super(serviceId, serviceName, usableArea, rentalCost, capacity, rentalType);
        this.freeService = freeService;
    }

    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                "} " + super.toString();
    }
}
