package bai_3.model;

public class ElectricalBill {
    private String billId;
    private String customerName;
    private String customerType;
    private int targetConsumption;

    public ElectricalBill() {
    }

    @Override
    public String toString() {
        return "ElectricalBill{" +
                "billId='" + billId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", targetConsumption=" + targetConsumption +
                '}';
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getTargetConsumption() {
        return targetConsumption;
    }

    public void setTargetConsumption(int targetConsumption) {
        this.targetConsumption = targetConsumption;
    }

    public ElectricalBill(String billId, String customerName, String customerType, int targetConsumption) {
        this.billId = billId;
        this.customerName = customerName;
        this.customerType = customerType;
        this.targetConsumption = targetConsumption;
    }
}
