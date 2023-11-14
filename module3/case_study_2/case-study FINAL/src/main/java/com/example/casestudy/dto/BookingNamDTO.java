package com.example.casestudy.dto;



public class BookingNamDTO {
    private int id;
    private String name;
    private int bookingId;
    private int petId;
    private String petName;
    private int employeeId;
    private String employeeName;
    private int typePetId;
    private String typePetName;
    private String startTime;
    private String endTime;
    private int statusId;
    private String statusName;
    private String serviceName;
    private int quantity;
    private String unit;
    private int priceTotal;

    public BookingNamDTO(String serviceName, int quantity, String unit, int priceTotal) {
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.unit=unit;
        this.priceTotal = priceTotal;
    }

    public BookingNamDTO(int id, String name, int bookingId, String petName, String employeeName, String typePetName, String startTime, String endTime, String statusName) {
        this.id = id;
        this.name=name;
        this.bookingId = bookingId;
        this.petName = petName;
        this.employeeName = employeeName;
        this.typePetName = typePetName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statusName = statusName;
    }

    public BookingNamDTO(int bookingId, String petName, String typePetName, String startTime, String endTime, String statusName) {
        this.bookingId = bookingId;
        this.petName = petName;
        this.typePetName = typePetName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statusName = statusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getTypePetId() {
        return typePetId;
    }

    public void setTypePetId(int typePetId) {
        this.typePetId = typePetId;
    }

    public String getTypePetName() {
        return typePetName;
    }

    public void setTypePetName(String typePetName) {
        this.typePetName = typePetName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
