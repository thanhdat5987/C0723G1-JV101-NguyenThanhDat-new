package com.example.casestudy.service;



import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;

import java.sql.Date;
import java.util.List;

public interface ICustomerAdminService {
    List<Customer> display();
    void saveAccount(Account account);
    int searchIdAccount(String username);
    boolean saveCustomer(Customer customer);
    Customer findById(int updateId);
    int validateAccount(String username,String parrword);
    int validateCustomer(String name, String telephone, String email, Date birthday);
    boolean updateCustomer(Customer customer);
    boolean delete(int deleteId);

}
