package com.example.casestudy.service;

import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;

import java.sql.Date;

public interface IRegisterService {
    boolean checkUsername(String username);
    int getIdAccount(String username);
    void addNewAccount(Account account);
    void addNewCustomer(Customer customer);
    void addCustomer(String name, Date birthday, String phone, String email, String address, int gender, int idAccount);

}
