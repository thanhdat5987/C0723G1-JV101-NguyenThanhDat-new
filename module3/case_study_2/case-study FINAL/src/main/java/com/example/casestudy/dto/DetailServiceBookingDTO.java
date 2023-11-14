package com.example.casestudy.dto;

public class DetailServiceBookingDTO {


    public int getDetailServiceId() {
        return detailServiceId;
    }

    public void setDetailServiceId(int detailServiceId) {
        this.detailServiceId = detailServiceId;
    }
    private int detailServiceId;
    private int bookingId;
    private String petName;
    private String customerName;
    private String employeeName;
    private String startTime;

    private String endTime;
    private String serviceName;
    private int quantity;
    private int price;
    private int total;
    private String customerComment;
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }


    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public DetailServiceBookingDTO(int detailServiceId, String petName, String customerName, String employeeName, String startTime, String endTime, String serviceName, int quantity, int price, int total, String customerComment) {
        this.detailServiceId = detailServiceId;
        this.petName = petName;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.customerComment = customerComment;
    }
}
