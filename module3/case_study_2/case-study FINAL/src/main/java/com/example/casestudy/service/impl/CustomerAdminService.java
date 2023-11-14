package com.example.casestudy.service.impl;


import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;
import com.example.casestudy.repository.ICustomerAdminRepository;
import com.example.casestudy.repository.impl.CustomerAdminRepository;
import com.example.casestudy.service.ICustomerAdminService;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class CustomerAdminService implements ICustomerAdminService {
    private ICustomerAdminRepository customerAdminRepository = new CustomerAdminRepository();
    private final String REGEX_NAME = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
    private final String REGEX_TELEPHONE = "^0(3|5|7|8|9)\\d{8}$";
    private final String REGEX_EMAIL = "^[a-z][a-z0-9_\\.]{4,31}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    private static final String REGEX_PASSWORD ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
    private static final String REGEX_USERNAME ="^\\w([._](?![._-])|\\w){3,18}\\w$";
    @Override
    public List<Customer> display() {
        return customerAdminRepository.display();
    }

    @Override
    public void saveAccount(Account account) {
        customerAdminRepository.saveAccount(account);
    }

    @Override
    public int searchIdAccount(String username) {
        return customerAdminRepository.searchIdAccount(username);
    }

    @Override
    public boolean saveCustomer(Customer customer) {

        return customerAdminRepository.saveCustomer(customer);
    }

    @Override
    public Customer findById(int updateId) {

        return customerAdminRepository.findById(updateId);
    }

    @Override
    public int validateAccount(String username, String parrword) {
        if (!username.matches(REGEX_USERNAME)){
            return 1;
        }else if (!parrword.matches(REGEX_PASSWORD)){
            return 2;
        }else {
            return 0;
        }
    }

    @Override
    public int validateCustomer(String name, String telephone, String email, Date birthday) {
        LocalDate current= LocalDate.now();
        long epochMilliStartTime = birthday.getTime();
        LocalDate dob = Instant.ofEpochMilli(epochMilliStartTime)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        if (!name.matches(REGEX_NAME)){
            return 1;
        }
        else if (!dob.isBefore(current)){
            return 2;
        }else if (!telephone.matches(REGEX_TELEPHONE)){
            return 3;
        }else if (!email.matches(REGEX_EMAIL)){
            return 4;
        }
        return 0;

    }

    @Override
    public boolean updateCustomer(Customer customer) {
    return customerAdminRepository.updateCustomer(customer);
    }

    @Override
    public boolean delete(int deleteId) {
        return customerAdminRepository.delete(deleteId);
    }
}
