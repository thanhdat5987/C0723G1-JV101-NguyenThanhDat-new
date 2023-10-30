package com.example.customer.repository;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    Customer display();
    Customer findById(int idCheck);
    void updateCustomer(Customer customer);
    void removeCustomer(int id);
}
