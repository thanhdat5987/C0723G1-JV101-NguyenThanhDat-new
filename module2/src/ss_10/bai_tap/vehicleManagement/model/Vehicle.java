package ss_10.bai_tap.vehicleManagement.model;

public class Vehicle {
    private String licensePlate;
    private String brandName;
    private int yearOfManufacture;
    private String ownerName;
    public Vehicle(){}

    public Vehicle(String licensePlate, String brandName, int yearOfManufacture, String ownerName) {
        this.licensePlate = licensePlate;
        this.brandName = brandName;
        this.yearOfManufacture = yearOfManufacture;
        this.ownerName = ownerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brandName='" + brandName + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
