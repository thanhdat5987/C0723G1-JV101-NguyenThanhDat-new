package ss_10.bai_tap.vehicleManagement.model;

public class MotoBike extends Vehicle{
    private String engineCapacity;

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public MotoBike(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public MotoBike(String licensePlate, String brandName, int yearOfManufacture, String ownerName, String engineCapacity) {
        super(licensePlate, brandName, yearOfManufacture, ownerName);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "MotoBike{" +
                "engineCapacity='" + engineCapacity + '\'' +
                "} " + super.toString();
    }
}
