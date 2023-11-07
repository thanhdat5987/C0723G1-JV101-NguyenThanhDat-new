package com.example.quan_ly_booking.service;

import com.example.quan_ly_booking.model.*;

import java.sql.SQLException;
import java.util.List;

public interface IBookingService {
    void insertBooking(Booking booking) throws SQLException;
    Booking selectBooking(int id) throws SQLException;
    List<BookingDTO> selectAllBooking() throws SQLException;
    boolean deleteBooking(int id) throws SQLException;
    boolean updateBooking(Booking booking) throws SQLException;
    List<BookingStatus> selectBookingStatus() throws SQLException;
    List<Employee> selectEmployeelist() throws SQLException;
    List<Pet> selectPetList() throws SQLException;
    List<Pet> selectPetOfCustomerList() throws SQLException;

    void insertCustomerBooking(Booking booking) throws SQLException;
    void insertDetailService(DetailService detailService) throws SQLException;
    List<Service> selectServiceList() throws SQLException;
    List<DetailServiceBookingDTO> selectDetailServiceList(int id) throws SQLException;
    DetailServiceDTO selectDetailService(int id) throws SQLException;
    boolean updateDetailService(DetailService detailService) throws SQLException;

}
