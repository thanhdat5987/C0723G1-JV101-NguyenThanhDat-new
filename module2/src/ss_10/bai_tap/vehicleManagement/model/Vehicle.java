package ss_10.bai_tap.vehicleManagement.model;

public class Vehicle {
    private String licensePlate;
    private String manufacturer;
    private int yearOfManufacture;
    private String ownerName;
    public Vehicle(){}

    public Vehicle(String licensePlate, String manufacturer, int yearOfManufacture, String ownerName) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.ownerName = ownerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
    public java.lang.String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brandName='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
