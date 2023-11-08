package com.example.quan_ly_booking.model;

public class PetBooking {
    private int petId;
    private String petName;

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

    public PetBooking(int petId, String petName) {
        this.petId = petId;
        this.petName = petName;
    }
}
