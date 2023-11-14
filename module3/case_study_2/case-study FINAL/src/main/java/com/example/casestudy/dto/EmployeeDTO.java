package com.example.casestudy.dto;

import java.sql.Date;

public class EmployeeDTO {
    private int id;
    private String name;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private String address;
    private String identificationCard;
    private int salary;
    private String username;
private String image;

    public EmployeeDTO(int id, String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary, String username, String image) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
        this.username = username;
        this.image = image;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary, String username) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
        this.username = username;
    }

    public EmployeeDTO(int id, String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary, String username) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
        this.username = username;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
