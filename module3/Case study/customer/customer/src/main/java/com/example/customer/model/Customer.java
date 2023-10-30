package com.example.customer.model;

import java.sql.Date;


public class Customer {
    private int id;
    private String name;
    private Date birthday;
    private String telephone;
    private String email;
    private String address;
    private int gender;
    private Account account;

    public Customer(int id, String name, Date birthday, String telephone, String email, String address, int gender, Account account) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.account = account;
    }

    public Customer(int id, String name, Date birthday, String telephone, String email, String address, int gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public Customer(String name, Date birthday, String telephone, String email, String address, int gender) {
        this.name = name;
        this.birthday = birthday;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.gender = gender;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
