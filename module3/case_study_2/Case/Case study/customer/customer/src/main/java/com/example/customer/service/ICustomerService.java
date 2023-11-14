package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer display();
    Customer findById(int id);
    void updateCustomer(Customer customer);
    void removeCustomer(int id);
}
