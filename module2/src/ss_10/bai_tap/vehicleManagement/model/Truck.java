package ss_10.bai_tap.vehicleManagement.model;

public class Truck extends Vehicle{
    private String truckWeight;

    public Truck(String truckWeight) {
        this.truckWeight = truckWeight;
    }

    public Truck(String licensePlate, String manufacturer, int yearOfManufacture, String ownerName, String truckWeight) {
        super(licensePlate, manufacturer, yearOfManufacture, ownerName);
        this.truckWeight = truckWeight;
    }

    public String getTruckWeight() {
        return truckWeight;
    }

    public void setTruckWeight(String truckWeight) {
        this.truckWeight = truckWeight;
    }

    @Override
    public java.lang.String toString() {
        return "Truck{" +
                "truckWeight='" + truckWeight + '\'' +
                "} " + super.toString();
    }
}
