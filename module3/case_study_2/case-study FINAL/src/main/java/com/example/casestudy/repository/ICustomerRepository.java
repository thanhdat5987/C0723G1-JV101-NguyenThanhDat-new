package com.example.casestudy.repository;


import com.example.casestudy.dto.BookingNamDTO;
import com.example.casestudy.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    Customer display( int id);
    Customer findById(int idCheck);
    boolean updateCustomer(Customer customer);
    void removeCustomer(int id);
    List<BookingNamDTO> history(int id);
   BookingNamDTO detail(int bookingId);
}
