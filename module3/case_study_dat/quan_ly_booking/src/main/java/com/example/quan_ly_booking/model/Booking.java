package com.example.quan_ly_booking.model;

public class Booking {
    private int bookingId;
    private int petId;
    private int employeeId;
    private String bookingTime;
    private String estimatedTimeOfArrival;
    private String startTime;
    private String endTime;
    private int statusId;
    private int deleteStatus;
    private String customerComment;

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public Booking(int bookingId, int petId, int employeeId, String bookingTime, String estimatedTimeOfArrival, String startTime, String endTime, int statusId, int deleteStatus, String customerComment) {
        this.bookingId = bookingId;
        this.petId = petId;
        this.employeeId = employeeId;
        this.bookingTime = bookingTime;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statusId = statusId;
        this.deleteStatus = deleteStatus;
        this.customerComment = customerComment;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Booking(int bookingId, int petId, int employeeId, String bookingTime, String estimatedTimeOfArrival, String startTime, String endTime, int statusId, int deleteStatus) {
        this.bookingId = bookingId;
        this.petId = petId;
        this.employeeId = employeeId;
        this.bookingTime = bookingTime;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statusId = statusId;
        this.deleteStatus = deleteStatus;
    }

    public Booking(int bookingId, int petId, int employeeId, String bookingTime, String estimatedTimeOfArrival, String startTime, String endTime, int statusId) {
        this.bookingId = bookingId;
        this.petId = petId;
        this.employeeId = employeeId;
        this.bookingTime = bookingTime;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statusId = statusId;
    }
    public Booking(int petId, int employeeId) {
        this.petId = petId;
        this.employeeId = employeeId;
    }

    public Booking(int petId, String estimatedTimeOfArrival, String customerComment ) {
        this.petId = petId;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.customerComment = customerComment;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public Booking() {
    }

    public Booking(int bookingId, int petId, int employeeId, String startTime, String endTime, int statusId) {
        this.bookingId = bookingId;
        this.petId = petId;
        this.employeeId = employeeId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statusId = statusId;
    }
}
