package case_study.furama.model;

public class Customer extends Person{
    private String customerId;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String gender, String citizenId, String phoneNumber, String email, String customerId, String customerType, String address) {
        super(name, dateOfBirth, gender, citizenId, phoneNumber, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
