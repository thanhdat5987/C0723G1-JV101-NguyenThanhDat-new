package com.example.casestudy.model;

public class Pet {
    private int id;
    private String name;
    private int weight;
    private String descriptions;
    private int id_type_pet;
    private int id_customer;


    public Pet(String name, int weight, String descriptions, int id_type_pet, int id_customer) {
        this.name= name;
        this.weight= weight;
        this.descriptions= descriptions;
        this.id_type_pet= id_type_pet;
        this.id_customer=id_customer;
    }

    public Pet(int id, String name, int weight, String descriptions, int id_type_pet, int id_customer) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.descriptions = descriptions;
        this.id_type_pet = id_type_pet;
        this.id_customer = id_customer;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getId_type_pet() {
        return id_type_pet;
    }

    public void setId_type_pet(int id_type_pet) {
        this.id_type_pet = id_type_pet;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }
}
