package com.example.casestudy.service.impl;

import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;
import com.example.casestudy.repository.IRegisterRepository;
import com.example.casestudy.repository.impl.RegisterRepository;
import com.example.casestudy.service.IRegisterService;

import java.sql.Date;

public class RegisterService implements IRegisterService {
    private final IRegisterRepository registerRepository = new RegisterRepository();

    @Override
    public boolean checkUsername(String username) {
        return registerRepository.checkUsername(username);
    }

    @Override
    public int getIdAccount(String username) {
        return registerRepository.getIdAccount(username);
    }

    @Override
    public void addNewAccount(Account account) {
        registerRepository.addNewAccount(account);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        registerRepository.addNewCustomer(customer);
    }

    @Override
    public void addCustomer(String name, Date birthday, String phone, String email, String address, int gender, int idAccount) {
        registerRepository.addCustomer(name,birthday,phone,email,address,gender,idAccount);
    }
}
