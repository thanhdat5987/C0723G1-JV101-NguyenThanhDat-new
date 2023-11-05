package com.example.quan_ly_booking.service.impl;

import com.example.quan_ly_booking.model.Booking;
import com.example.quan_ly_booking.model.BookingDTO;
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
}
