package com.example.quan_ly_booking.model;

public class BookingDTO {
    private int bookingId;
    private String petName;
    private String customerName;
    private String employeeName;
    private String bookingTime;
    private String estimatedTimeOfArrival;
    private String startTime;
    private String endTime;
    private String bookingStatus;


    public BookingDTO(int bookingId, String petName, String customerName, String employeeName, String bookingTime, String estimatedTimeOfArrival, String startTime, String endTime, String bookingStatus) {
        this.bookingId = bookingId;
        this.petName = petName;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.bookingTime = bookingTime;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingStatus = bookingStatus;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

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

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(String estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
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

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public BookingDTO() {
    }

    public BookingDTO(int bookingId, String petName, String customerName, String bookingTime, String estimatedTimeOfArrival, String startTime, String endTime, String bookingStatus) {
        this.bookingId = bookingId;
        this.petName = petName;
        this.customerName = customerName;
        this.bookingTime = bookingTime;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingStatus = bookingStatus;
    }
}
