package com.example.quan_ly_booking.service.impl;

import com.example.quan_ly_booking.model.*;
import com.example.quan_ly_booking.repository.IBookingRepository;
import com.example.quan_ly_booking.repository.impl.BookingRepository;
import com.example.quan_ly_booking.service.IBookingService;

import java.sql.SQLException;
import java.util.List;

public class BookingService implements IBookingService {
private IBookingRepository bookingRepository = new BookingRepository();
    @Override
    public void insertBooking(Booking booking)throws SQLException  {
        bookingRepository.insertBooking(booking);
    }

    @Override
    public Booking selectBooking(int id) throws SQLException {
        return bookingRepository.selectBooking(id);
    }

    @Override
    public List<BookingDTO> selectAllBooking() throws SQLException {
        return bookingRepository.selectAllBooking();
    }

    @Override
    public boolean deleteBooking(int id) throws SQLException {
        return bookingRepository.deleteBooking(id);
    }

    @Override
    public boolean updateBooking(Booking booking) throws SQLException {
        return bookingRepository.updateBooking(booking);
    }

    @Override
    public List<BookingStatus> selectBookingStatus() throws SQLException {
        return bookingRepository.selectBookingStatus();
    }

    @Override
    public List<EmployeeBooking> selectEmployeelist() throws SQLException {
        return bookingRepository.selectEmployeelist();
    }

    @Override
    public List<PetBooking> selectPetList() throws SQLException {
        return bookingRepository.selectPetList();
    }

    @Override
    public List<PetBooking> selectPetOfCustomerList() throws SQLException {
        return bookingRepository.selectPetOfCustomerList();
    }

    @Override
    public void insertCustomerBooking(Booking booking) throws SQLException {
        bookingRepository.insertCustomerBooking(booking);
    }

    @Override
    public void insertDetailService(DetailService detailService) throws SQLException {
bookingRepository.insertDetailService(detailService);
    }

    @Override
    public List<ServiceBooking> selectServiceList() throws SQLException {
        return bookingRepository.selectServiceList();
    }

    @Override
    public List<DetailServiceBookingDTO> selectDetailServiceList(int id) throws SQLException {
        return bookingRepository.selectDetailServiceList(id);
    }

    @Override
    public DetailServiceDTO selectDetailService(int id) throws SQLException {
        return bookingRepository.selectDetailService(id);
    }

    @Override
    public boolean updateDetailService(DetailService detailService) throws SQLException {
        return bookingRepository.updateDetailService(detailService);
    }


}
