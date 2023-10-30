package com.example.customer.model;

public class Account {
    private int idAccount;
    private String nameAccount;

    public Account(int idAccount, String nameAccount) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
    }

    public Account(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }
}
