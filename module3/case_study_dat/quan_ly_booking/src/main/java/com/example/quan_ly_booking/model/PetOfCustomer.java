package com.example.quan_ly_booking.model;

public class PetOfCustomer {
    private int petId;
    private String petName;

    public PetOfCustomer(int petId, String petName) {
        this.petId = petId;
        this.petName = petName;
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
}
