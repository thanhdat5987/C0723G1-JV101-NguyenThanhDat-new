package com.example.casestudy.repository;


import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;

import java.util.List;

public interface ICustomerAdminRepository {
    List<Customer> display();
    void saveAccount(Account account);
    boolean saveCustomer(Customer customer);
    int searchIdAccount(String username);
    Customer findById(int updateId);
    boolean updateCustomer(Customer customer);
    boolean delete(int deleteId);
}
