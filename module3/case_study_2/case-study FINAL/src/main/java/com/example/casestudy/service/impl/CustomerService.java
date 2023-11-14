package com.example.casestudy.service.impl;


import com.example.casestudy.dto.BookingNamDTO;
import com.example.casestudy.model.Customer;
import com.example.casestudy.repository.ICustomerRepository;
import com.example.casestudy.repository.impl.CustomerRepository;
import com.example.casestudy.service.ICustomerService;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    private final String REGEX_NAME = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,5}$";
    private final String REGEX_TELEPHONE = "^0(3|5|7|8|9)\\d{8}$";
    private final String REGEX_EMAIL = "^[a-z][a-z0-9_\\.]{4,31}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    @Override
    public Customer display(int id) {
        return customerRepository.display(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
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

        return customerRepository.updateCustomer(customer);
    }

    @Override
    public void removeCustomer(int id) {
        customerRepository.removeCustomer(id);
    }

    @Override
    public List<BookingNamDTO> history(int id) {
        return customerRepository.history(id);
    }

    @Override
    public BookingNamDTO detail(int bookingId) {
        return customerRepository.detail(bookingId);
    }
}
