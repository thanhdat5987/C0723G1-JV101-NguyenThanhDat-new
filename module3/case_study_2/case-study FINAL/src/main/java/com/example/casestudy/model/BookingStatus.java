package com.example.casestudy.model;

public class BookingStatus {
    private int bookingStatusId;
    private String bookingStatusName;

    public int getBookingStatusId() {
        return bookingStatusId;
    }

    public void setBookingStatusId(int bookingStatusId) {
        this.bookingStatusId = bookingStatusId;
    }

    public String getBookingStatusName() {
        return bookingStatusName;
    }

    public void setBookingStatusName(String bookingStatusName) {
        this.bookingStatusName = bookingStatusName;
    }

    public BookingStatus(int bookingStatusId, String bookingStatusName) {
        this.bookingStatusId = bookingStatusId;
        this.bookingStatusName = bookingStatusName;
    }
}
