package case_study.furama.model;

public class Villa extends Facility{
    private String roomStandards;
    private float poolArea;
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(String serviceId, String serviceName, float usableArea, int rentalCost, int capacity, String rentalType, String roomStandard, float poolArea, int numberOfFloor) {
        super(serviceId, serviceName, usableArea, rentalCost, capacity, rentalType);
        this.roomStandards = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandards + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloor=" + numberOfFloor +
                "} " + super.toString();
    }
}
