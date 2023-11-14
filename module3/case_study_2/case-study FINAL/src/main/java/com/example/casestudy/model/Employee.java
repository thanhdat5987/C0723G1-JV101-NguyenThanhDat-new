package com.example.casestudy.model;

import java.sql.Date;

public class Employee {
    private int id;
    private String name;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private String address;
    private String identificationCard;
    private int salary;
    private int idAccount;
    private String image;

    public Employee() {
    }

    public Employee(String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
    }

    public Employee(int id, String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary, String image) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
        this.image = image;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Employee(int id, String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary, int idAccount, String image) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
        this.idAccount = idAccount;
        this.image = image;
    }

    public Employee(String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary,String image, int idAccount) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
        this.image = image;
        this.idAccount = idAccount;
    }

    public Employee(int id, String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
    }

    public Employee(int id, String name, Date birthday, String phoneNumber, String email, String address, String identificationCard, int salary, int idAccount) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.identificationCard = identificationCard;
        this.salary = salary;
        this.idAccount = idAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getIdAccount() {
        return idAccount;
    }

    public void setId_account(int idAccount) {
        this.idAccount = idAccount;
    }
}
