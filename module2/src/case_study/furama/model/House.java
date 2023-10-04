package case_study.furama.model;

public class House extends Facility {
private String roomStandards;
private int numberOfFloor;

    public House() {
    }

    public House(String serviceId, String serviceName, float usableArea, int rentalCost, int capacity, String rentalType, String roomStandards, int numberOfFloor) {
        super(serviceId, serviceName, usableArea, rentalCost, capacity, rentalType);
        this.roomStandards = roomStandards;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandards='" + roomStandards + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                "} " + super.toString();
    }
}
